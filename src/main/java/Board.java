import java.util.Random;

public class Board {
    private Cell[][] board;
    private int rows;
    private int cols;
    private int numMines;

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.numMines = mines;
        board = new Cell[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell();
            }

            placeMines();
            NumAjacentMines();
        }
    }

    private void placeMines () {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < numMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!cells[row][col].hasMine()) {

            }
        }
    }

    private void NumAjacentMines(){

    }
}