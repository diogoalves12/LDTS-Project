public class Board {
    private Cell[][] board;
    private int rows;
    private int cols;
    private int mines;

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        board = new Cell[rows][cols];
        CreateBoard();
    }

    private void CreateBoard() {
        // --> completar
    }


}

