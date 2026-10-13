package com.sammontalvo.soloro.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sammontalvo.soloro.SoloroGame;

/** Placeholder title screen proving the render loop, viewport, and text drawing work. */
public class TitleScreen extends ScreenAdapter {
    private final SoloroGame game;
    private final Viewport viewport;
    private final BitmapFont font;
    private final GlyphLayout layout = new GlyphLayout();

    public TitleScreen(SoloroGame game) {
        this.game = game;
        this.viewport = new FitViewport(SoloroGame.VIRTUAL_WIDTH, SoloroGame.VIRTUAL_HEIGHT);
        // libGDX's built-in default font; replaced once we have real assets
        this.font = new BitmapFont();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.06f, 0.06f, 0.14f, 1f);
        viewport.apply();
        game.batch.setProjectionMatrix(viewport.getCamera().combined);

        layout.setText(font, SoloroGame.TITLE);
        float x = (SoloroGame.VIRTUAL_WIDTH - layout.width) / 2f;
        float y = (SoloroGame.VIRTUAL_HEIGHT + layout.height) / 2f;

        game.batch.begin();
        font.draw(game.batch, layout, x, y);
        game.batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
