package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetupTest {

    @Test
    public void testBoardSetup() {
        GameSetup setup = new GameSetup(20,20,5,GameSetup.Difficulty.HARD);
        assertEquals(20, setup.getBoardRows());
        assertEquals(20, setup.getBoardCols());
        assertEquals(5, setup.getMineFrequency());
        assertEquals(GameSetup.Difficulty.HARD, setup.getDifficulty());
    }

    @Test
    public void testEasyDifficulty() {
        GameSetup setup = new GameSetup(GameSetup.Difficulty.EASY);
        assertEquals(8, setup.getBoardRows());
        assertEquals(8, setup.getBoardCols());
        assertEquals(8, setup.getMineFrequency());
    }

    @Test
    public void testNormalDifficulty() {
        GameSetup setup = new GameSetup(GameSetup.Difficulty.NORMAL);
        assertEquals(14, setup.getBoardRows());
        assertEquals(14, setup.getBoardCols());
        assertEquals(6, setup.getMineFrequency());
    }

    @Test
    public void testHardDifficulty() {
        GameSetup setup = new GameSetup(GameSetup.Difficulty.HARD);
        assertEquals(20, setup.getBoardRows());
        assertEquals(20, setup.getBoardCols());
        assertEquals(5, setup.getMineFrequency());
    }

}
