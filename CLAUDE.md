# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

Soloro is a 2D RPG (Final Fantasy / Dragon Quest style) built with libGDX in Java. Target platform is Android; the desktop (LWJGL3) build exists for fast iteration.

## Commands

Use `./gradlew` in bash/WSL and `.\gradlew.bat` in PowerShell.

```bash
./gradlew lwjgl3:run          # launch the desktop build (working dir is assets/)
./gradlew check               # tests + Spotless + Checkstyle — run before any PR; this is what CI runs
./gradlew spotlessApply       # auto-format; fix Spotless failures with this, never by hand
./gradlew core:test           # unit tests only
./gradlew core:test --tests 'com.sammontalvo.soloro.SoloroGameTest'                         # single class
./gradlew core:test --tests 'com.sammontalvo.soloro.SoloroGameTest.virtualResolutionIs16By9' # single method
```

CI (`.github/workflows/ci.yml`) runs `./gradlew check` on JDK 21 for every PR and push to `main`.

`main` is protected by a GitHub ruleset ("Protect main"; lives on GitHub, not in this repo): no direct or force pushes, PRs required (0 approvals), unresolved review threads block merge, and the `check` job must pass on a branch that's up to date with `main`. Merged branches are auto-deleted on GitHub; run `git fetch --prune` locally. If the `check` job in `ci.yml` is renamed, update the ruleset too or merges stay blocked. Inspect the active rules with `gh api repos/montal95/soloro/rules/branches/main`.

## Architecture

- `core/` holds all game code and all tests. It depends only on `gdx`, never on a backend, so it stays portable to Android.
- `lwjgl3/` is a thin desktop launcher. It adds `assets/` to its resources and runs from `assets/`, so `Gdx.files.internal("...")` paths are relative to `assets/`.
- An `android` module is planned but not yet in `settings.gradle` (needs the Android SDK).
- `SoloroGame` (extends libGDX `Game`) is the shared entry point every launcher instantiates. It owns whole-game resources (the shared `SpriteBatch`) and switches between `Screen`s in `core/.../screens/`.
- Rendering uses a low-res virtual resolution (`SoloroGame.VIRTUAL_WIDTH` x `VIRTUAL_HEIGHT`, 480x270, 16:9) scaled up through a `FitViewport` per screen for a crisp pixel look. Screens draw with `game.batch` after applying their viewport's camera.
- libGDX objects holding native resources (`SpriteBatch`, `BitmapFont`, textures) must be disposed explicitly. `Game.dispose()` only hides the active screen, which is why `SoloroGame.dispose()` disposes it itself.
- Unit tests run on the JVM without a GL context, so test game logic that doesn't touch `Gdx.*` graphics APIs.

## Constraints

- Builds use JDK 21 but compile with `options.release = 17` for Android desugaring compatibility. Don't use Java language or API features newer than 17.
- Formatting is owned by Spotless (google-java-format, AOSP 4-space style). Checkstyle (`config/checkstyle/checkstyle.xml`, `maxWarnings = 0`) covers only naming, imports, and bug-prone patterns, so the two never conflict. Suppress a rule locally with `@SuppressWarnings("checkstyle:RuleName")`.
- Dependency versions live in `gradle.properties` (`gdxVersion`, `junitVersion`, etc.), not inline in build files.

## Windows / git gotchas

- `gradlew` must stay executable in git (`100755`). Windows doesn't track the bit; if it's lost, restore it with `git update-index --chmod=+x gradlew`, or CI fails with "Permission denied".
- Windows PowerShell 5.1 mangles embedded double quotes in native-command arguments. For multi-line commit messages, write the message to a file and use `git commit -F <file>`.
