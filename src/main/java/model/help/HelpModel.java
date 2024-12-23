package model.help;

import java.util.ArrayList;
import java.util.List;

public class HelpModel {
    private final List<String> text;

    private static final String[] ASCII_TITLE = {
            "██╗  ██╗███████╗██╗     ██████╗ ",
            "██║  ██║██╔════╝██║     ██╔══██╗",
            "███████║█████╗  ██║     ██████╔╝",
            "██╔══██║██╔══╝  ██║     ██╔═══╝ ",
            "██║  ██║███████╗███████╗██║     ",
            "╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     "
    };

    public HelpModel() {
        text = new ArrayList<>();
        loadContent();
    }


    private void loadContent() {
        text.add("Welcome to Minesweeper!");
        text.add("The main objective of this game is to reveal all the cells in the board");
        text.add("without revealing any of the mines.");
        text.add("The game ends when the player successfully reveals all the cells or");
        text.add("when the player reveals a cell with a mine.");
        text.add("If you win, you can always play a harder difficulty, and if you lose you");
        text.add("can always play a easier difficulty.");
        text.add("To play:");
        text.add("Use Arrow Keys to move the cursor and press 'ENTER' to reveal the cell.");
        text.add("You can flag and unflag a cell by pressing 'F'");
        text.add("To QUIT the game, press 'Q' and to go back to the menu, press 'ESC'");
        text.add("Good luck!");
        text.add("Press 'ESC' or 'ARROW LEFT' to go back to the menu...");
    }

    public List<String> text() {
        return text;
    }

    public String getSection(int index) {
        if (index >= 0 && index < text.size()) {
            return text.get(index);
        } else {
            throw new IllegalArgumentException("Índice inválido: " + index);
        }
    }

    public int getTotalSections() {
        return text.size();
    }

    public String[] getAsciiTitle() { return ASCII_TITLE; }

}
