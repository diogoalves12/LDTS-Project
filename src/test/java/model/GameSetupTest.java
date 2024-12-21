package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetupTest {

    @Test
    public void testGetMineFrequencyEasy() {
        GameSetup gameSetup = new GameSetup(GameSetup.Difficulty.EASY);
        assertEquals(8, gameSetup.getMineFrequency());
    }

    @Test
    public void testGetMineFrequencyNormal() {
        GameSetup gameSetup = new GameSetup(GameSetup.Difficulty.NORMAL);
        assertEquals(6, gameSetup.getMineFrequency());
    }

    @Test
    public void testGetMineFrequencyHard() {
        GameSetup gameSetup = new GameSetup(GameSetup.Difficulty.HARD);
        assertEquals(5, gameSetup.getMineFrequency());
    }

}
