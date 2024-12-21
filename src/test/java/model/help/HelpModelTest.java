package model.help;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelpModelTest {

    @Test
    public void testInitialization() {
        HelpModel model = new HelpModel();

        assertEquals(4, model.getTotalSections());

        List<String> expectedText = List.of(
                "Welcome to Minesweeper!",
                "The main objective of this game is to reveal all the cells in the board without revealing any of the mines.",
                "The game ends when the player successfully reveals all the cells or when the player reveals a cell with a mine.",
                "If you win, you can always play a harder difficulty, and if you lose you can either restart the game play an easier difficulty."
        );

        assertEquals(expectedText, model.text());
    }

    @Test
    public void testContent() {
        HelpModel model = new HelpModel();

        assertEquals("Welcome to Minesweeper!", model.getSection(0));
        assertEquals("The main objective of this game is to reveal all the cells in the board without revealing any of the mines.", model.getSection(1));
        assertEquals("The game ends when the player successfully reveals all the cells or when the player reveals a cell with a mine.", model.getSection(2));
        assertEquals("If you win, you can always play a harder difficulty, and if you lose you can either restart the game play an easier difficulty.", model.getSection(3));
    }

    @Test
    public void testInvalidIndex() {
        HelpModel model = new HelpModel();

        assertThrows(IllegalArgumentException.class, () -> model.getSection(-1));
        assertThrows(IllegalArgumentException.class, () -> model.getSection(4));
    }

    @Test
    public void testTotalSections() {
        HelpModel model = new HelpModel();

        assertEquals(4, model.getTotalSections());
    }

}
