package com.sammontalvo.soloro.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.sammontalvo.soloro.SoloroGame;

/** Desktop launcher. Used for fast iteration during development; Android gets its own launcher later. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle(SoloroGame.TITLE);
        config.setWindowedMode(SoloroGame.VIRTUAL_WIDTH * 2, SoloroGame.VIRTUAL_HEIGHT * 2);
        config.useVsync(true);
        config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        new Lwjgl3Application(new SoloroGame(), config);
    }
}
