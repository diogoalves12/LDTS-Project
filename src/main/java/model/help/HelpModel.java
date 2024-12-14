package model.help;

import java.util.ArrayList;
import java.util.List;

public class HelpModel {
    private final List<String> text;

    public HelpModel() {
        text = new ArrayList<>();
        loadContent();
    }


    private void loadContent() {
        text.add("Welcome to Minesweeper!");
        text.add("The main objective of this game is to reveal all the cells in the board without revealing any of the mines.");
        text.add("The game ends when the player successfully reveals all the cells or when the player reveals a cell with a mine.");
        text.add("If you win, you can always play a harder difficulty, and if you lose you can either restart the game play an easier difficulty.");

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

}
