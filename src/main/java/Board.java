public class Board {
    private Cell[][] board;
    private int rows;
    private int cols;
    private int mines;

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        CreateBoard();
    }

    private void CreateBoard() {
        board = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell();
            }
        }

        // --> completar
        // bombas
        // bombas adjacentes
    }



}

