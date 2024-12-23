package minesweeper.model.help;

import java.util.List;

import minesweeper.model.help.HelpModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelpModelTest {

    @Test
    public void testInitialization() {
        HelpModel model = new HelpModel();

        assertEquals(13, model.getTotalSections());

        List<String> expectedText = List.of(
                "Welcome to Minesweeper!",
                "The main objective of this game is to reveal all the cells in the board",
                "without revealing any of the mines.",
                "The game ends when the player successfully reveals all the cells or",
                "when the player reveals a cell with a mine.",
                "If you win, you can always play a harder difficulty, and if you lose you",
                "can always play a easier difficulty.",
                "To play:",
                "Use Arrow Keys to move the cursor and press 'ENTER' to reveal the cell.",
                "You can flag and unflag a cell by pressing 'F'",
                "To QUIT the game, press 'Q' and to go back to the menu, press 'ESC'",
                "Good luck!",
                "Press 'ESC' or 'ARROW LEFT' to go back to the menu..."
        );

        assertEquals(expectedText, model.text());
    }

    @Test
    public void testGetAsciiTitle() {
        HelpModel model = new HelpModel();

        String[] expectedAsciiTitle = {
                "██╗  ██╗███████╗██╗     ██████╗ ",
                "██║  ██║██╔════╝██║     ██╔══██╗",
                "███████║█████╗  ██║     ██████╔╝",
                "██╔══██║██╔══╝  ██║     ██╔═══╝ ",
                "██║  ██║███████╗███████╗██║     ",
                "╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     "
        };

        assertEquals(expectedAsciiTitle.length, model.getAsciiTitle().length);
        for (int i = 0; i < expectedAsciiTitle.length; i++) {
            assertEquals(expectedAsciiTitle[i], model.getAsciiTitle()[i]);
        }
    }

    @Test
    public void testContent() {
        HelpModel model = new HelpModel();

        assertEquals("Welcome to Minesweeper!", model.getSection(0));
        assertEquals("The main objective of this game is to reveal all the cells in the board", model.getSection(1));
        assertEquals("without revealing any of the mines.", model.getSection(2));
        assertEquals("Good luck!", model.getSection(11));
        assertEquals("Press 'ESC' or 'ARROW LEFT' to go back to the menu...", model.getSection(12));
    }

    @Test
    public void testInvalidIndex() {
        HelpModel model = new HelpModel();

        assertThrows(IllegalArgumentException.class, () -> model.getSection(-1));
        assertThrows(IllegalArgumentException.class, () -> model.getSection(13));
    }

    @Test
    public void testTotalSections() {
        HelpModel model = new HelpModel();

        assertEquals(13, model.getTotalSections());
    }

}
