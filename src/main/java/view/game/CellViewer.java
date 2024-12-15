package view.game;

import model.game.Cell;
import view.View;

import java.io.IOException;

public class CellViewer extends View<Cell> {

    private static final String COLOR_UNREVEALED = "#FFFFFF";
    private static final String COLOR_MINE = "#FF0000";
    private static final String COLOR_ADJACENT = "#00FF00";
    private static final String COLOR_DEFAULT = "#AAAAAA";
    private static final String DISPLAY_UNREVEALED = "#";
    private static final String DISPLAY_EMPTY = " ";
    private static final String DISPLAY_MINE = "*";

    public CellViewer(Cell model) {
        super(model);
    }

    @Override
    public void draw() throws IOException {
        Cell cell = getModel();
        String colorHex = COLOR_DEFAULT;
        String display = DISPLAY_EMPTY;

        if (!cell.isRevealed()) {
            colorHex = COLOR_UNREVEALED;
            display = DISPLAY_UNREVEALED;
        } else if (cell.hasMine()) {
            colorHex = COLOR_MINE;
            display = DISPLAY_MINE;
        } else {
            int adjacentMines = getAdjacentMineCount();
            if (adjacentMines > 0) {
                colorHex = COLOR_ADJACENT;
                display = String.valueOf(adjacentMines);
            }
        }
    }

}
