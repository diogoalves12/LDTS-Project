package model.game;

public class Board {
    private static volatile Board instance;
    private final Cell[][] board;
    private final int rows;
    private final int cols;

    private Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Cell[rows][cols];
        initializeBoard();
    }

    // Singleton accessor
    public static Board getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Board not initialized");
        }
        return instance;
    }

    // Singleton initializer
    public static void initialize(int rows, int cols){
        synchronized (Board.class) {
            if( instance == null){
                instance = new Board(rows, cols);
            } else {
                throw new IllegalStateException("Board already initialized");
            }
        }
    }

    private void initializeBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = CellFactory.createCell(false, row, col);
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
        return (row >= 0 && row < rows ) && (col >= 0 && col < cols);
    }

}