package model.game;

import model.GameSetup;

public class Game {

    private final Board board;
    private final GameSetup setup;
    private Cursor cursor;

    public Game(GameSetup setup) {
        this.setup = setup;
        this.board = initializeBoard();
    }

    private Board initializeBoard() {
        Board.initialize(setup.getBoardRows(), setup.getBoardCols());
        BoardBuilder builder = new BoardBuilder();
        builder.buildBoard(setup.getMineFrequency());
        return Board.getInstance();
    }

    public Board getBoard() {
        return board;
    }

    public GameSetup getSetup() {
        return setup;
    }

    public int getRows(){
        return setup.getBoardRows();
    }

    public int getColumns(){
        return setup.getBoardRows();
    }

    public Cursor getCursor() { return cursor; }

    public int getCursorRow(){ return cursor.getRow(); }

    public int getCursorCol(){ return cursor.getCol(); }


}

