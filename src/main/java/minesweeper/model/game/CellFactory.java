package minesweeper.model.game;

public class CellFactory {
    public static Cell createCell(boolean hasMine, int row, int col) {
        if (hasMine) {
            return new MineCell(row, col);
        } else {
            return new NormalCell(row, col);
        }
    }

}



