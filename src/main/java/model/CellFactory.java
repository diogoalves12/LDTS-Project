package model;

public class CellFactory {
    public static Cell createCell(boolean hasMine, int row, int col) {
        if (hasMine) {
            return new MineCell(row, col);
        } else {
            return NormalCell(row, col);
        }
    }

}
