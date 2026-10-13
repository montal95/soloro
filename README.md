# Soloro

A 2D RPG in the spirit of Final Fantasy and Dragon Quest, built with [libGDX](https://libgdx.com/) in Java. Target platform: Android (Google Play), with desktop for development.

## Layout

```
core/     all game code (plain Java + libGDX); unit tests live here
lwjgl3/   desktop launcher
assets/   art, maps, and data shared by every platform
```

## Requirements

- JDK 21 (Temurin). Code compiles to Java 17 for Android compatibility.
- Android SDK (not needed yet; required once the android module is added)

## Commands

```bash
./gradlew lwjgl3:run   # launch the desktop build
./gradlew test         # run unit tests
./gradlew build        # compile + test + lint everything
./gradlew spotlessApply   # auto-format (google-java-format, AOSP 4-space style)
./gradlew check           # tests + Spotless + Checkstyle, without packaging
```

Formatting is owned by Spotless; Checkstyle (`config/checkstyle/checkstyle.xml`) covers naming, imports, and bug-prone patterns only, so the two never disagree.

## TODO

- [ ] Add android module (needs Android SDK / Android Studio)
- [x] Linter/formatter: Spotless + google-java-format (AOSP) and Checkstyle
