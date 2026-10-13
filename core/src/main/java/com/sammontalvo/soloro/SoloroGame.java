package com.sammontalvo.soloro;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sammontalvo.soloro.screens.TitleScreen;

/** Entry point shared by every platform launcher. Owns resources that live for the whole game. */
public class SoloroGame extends Game {
    public static final String TITLE = "Soloro";

    /**
     * Low-res virtual resolution; the viewport scales it up to the window for a crisp pixel look.
     */
    public static final int VIRTUAL_WIDTH = 480;

    public static final int VIRTUAL_HEIGHT = 270;

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new TitleScreen(this));
    }

    @Override
    public void dispose() {
        // Game.dispose() only hides the active screen, so dispose it explicitly
        if (getScreen() != null) {
            getScreen().dispose();
        }
        batch.dispose();
        super.dispose();
    }
}
