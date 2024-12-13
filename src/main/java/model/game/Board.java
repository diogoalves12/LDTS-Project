package model.game;

import model.Position;

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

    public void addCell(Position position, Cell cell) {
        if(inBounds(position)){
            board[position.getRow()][position.getCol()] = cell;
        }
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public Cell getCell(Position position) {
        if(inBounds(position)){
            return board[position.getRow()][position.getCol()];
        }
        return null;
    }

    private boolean inBounds(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return (row >= 0 && row < rows ) && (col >= 0 && col < cols);
    }

    public int getAdjacentMines(Position position) {
        int count = 0;

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0) continue;

                int newRow = position.getRow() + i;
                int newCol = position.getCol() + j;

                Position neighborPosition = new Position(newRow, newCol);

                if(inBounds(neighborPosition)){
                    Cell neighborCell = getCell(neighborPosition);
                    if(neighborCell != null && neighborCell.hasMine()){
                        count++;
                    }
                }

            }
        }
        return count;
    }


    public void revealEmptyArea(Position position) {
        if(!inBounds(position)) return;

        Cell cell = getCell(position);

        if(cell == null || cell.isRevealed()) return;

        cell.reveal();

        if(getAdjacentMines(position) == 0){
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(i != 0 || j != 0){
                        Position neighborPosition = new Position(position.getRow() + i, position.getCol() + j);
                        revealEmptyArea(neighborPosition);
                    }
                }
            }
        }
    }


}