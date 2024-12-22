package model.game;

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
    public void testLoadContent() {
        ArrayList<String> text = gameOver.text();
        assertNotNull(text);
        assertEquals(3, text.size());
        assertEquals("You lost!", text.get(0));
        assertEquals("Better luck next time!", text.get(1));
        assertEquals("Press 'ESC' to return to the menu.", text.get(2));
    }

    @Test
    public void testGetSection() {
        assertEquals("You lost!", gameOver.getSection(0));
        assertEquals("Better luck next time!", gameOver.getSection(1));
        assertEquals("Press 'ESC' to return to the menu.", gameOver.getSection(2));
    }

    @Test
    public void testGetSection2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameOver.getSection(-1));
        assertEquals("Índice inválido: -1", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> gameOver.getSection(3));
        assertEquals("Índice inválido: 3", exception.getMessage());
    }

    @Test
    public void testGetTotalSections() {
        assertEquals(3, gameOver.getTotalSections());
    }

}