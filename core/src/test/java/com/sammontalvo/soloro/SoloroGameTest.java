package com.sammontalvo.soloro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Smoke test: proves JUnit is wired into the core module. Real tests start with game logic. */
class SoloroGameTest {
    @Test
    void virtualResolutionIs16By9() {
        assertEquals(16 * SoloroGame.VIRTUAL_HEIGHT, 9 * SoloroGame.VIRTUAL_WIDTH);
    }
}
