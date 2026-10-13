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
./gradlew build        # compile + test everything
```

## TODO

- [ ] Add android module (needs Android SDK / Android Studio)
- [ ] Choose a linter/formatter (Spotless + google-java-format or Checkstyle)
