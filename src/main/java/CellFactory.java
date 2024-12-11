public class CellFactory {
    public static Cell createCell(boolean hasMine) {
        if (hasMine) {
            return new MineCell();      // MineCell() yet to be implemented
        } else {
            return NormalCell();        // NormalCell() yet to be implemented
        }
    }

}
