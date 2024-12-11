package model;

public class Board {
    private static Board instance;
    private final Cell[][] board;
    private int rows;
    private int cols;

    private Board() {
        this.rows = 0;
        this.cols = 0;
        board = new Cell[rows][cols];

        initializeBoard();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private void initializeBoard() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new NormalCell(row, col);
            }
        }

    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public void addCell(int row, int col, Cell cell) {
        if(inBounds(row,col)){
            board[row][col] = cell;
        }
    }

    public Cell getCell(int row, int col) {
        if(inBounds(row,col)){
            return board[row][col];
        }
        return null;
    }

    private boolean inBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}