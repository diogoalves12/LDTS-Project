package minesweeper.model.game;

import minesweeper.model.game.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {

    private GameOver gameOver;

    @BeforeEach
    public void setUp() {
        gameOver = new GameOver();
    }

    @Test
    public void testLoadContentLoss() {
        gameOver.loadContent(false);

        ArrayList<String> text = gameOver.text();
        assertNotNull(text);
        assertEquals(3, text.size());
        assertEquals("You lost!", text.get(0));
        assertEquals("Better luck next time!", text.get(1));
        assertEquals("Press 'ESC' to return to the menu.", text.get(2));
    }

    @Test
    public void testLoadContentWin() {
        gameOver.loadContent(true);

        ArrayList<String> text = gameOver.text();
        assertNotNull(text);
        assertEquals(3, text.size());
        assertEquals("You won!", text.get(0));
        assertEquals("Congratulations!", text.get(1));
        assertEquals("Press 'ESC' to return to the menu.", text.get(2));
    }

    @Test
    public void testGetSectionLoss() {
        gameOver.loadContent(false);

        assertEquals("You lost!", gameOver.getSection(0));
        assertEquals("Better luck next time!", gameOver.getSection(1));
        assertEquals("Press 'ESC' to return to the menu.", gameOver.getSection(2));
    }

    @Test
    public void testGetSectionWin() {
        gameOver.loadContent(true);

        assertEquals("You won!", gameOver.getSection(0));
        assertEquals("Congratulations!", gameOver.getSection(1));
        assertEquals("Press 'ESC' to return to the menu.", gameOver.getSection(2));
    }


    @Test
    public void testGetSection2() {
        gameOver.loadContent(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameOver.getSection(-1));
        assertEquals("Índice inválido: -1", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> gameOver.getSection(3));
        assertEquals("Índice inválido: 3", exception.getMessage());
    }

    @Test
    public void testGetTotalSectionsLoss() {
        gameOver.loadContent(false);

        assertEquals(3, gameOver.getTotalSections());
    }

    @Test
    public void testGetTotalSectionsWin() {
        gameOver.loadContent(true);

        assertEquals(3, gameOver.getTotalSections());
    }

    @Test
    public void testSetAndCheckHasWon() {
        gameOver.setHasWon(true);
        assertTrue(gameOver.hasWon());

        gameOver.setHasWon(false);
        assertFalse(gameOver.hasWon());
    }

}