package minesweeper.model.game;

import com.googlecode.lanterna.TerminalSize;
import minesweeper.model.GameSetup;
import minesweeper.model.Position;

import java.time.Clock;

public class Game {

    private final Board board;
    private final GameSetup setup;
    private Cursor cursor;
    private GameClock clock;

    public Game(GameSetup setup) {
        this.setup = setup;
        this.board = initializeBoard();
        this.cursor = new Cursor(new TerminalSize(setup.getBoardRows(), setup.getBoardCols()), new Position(0, 0));
        this.clock = new GameClock(Clock.systemUTC());
        clock.startClock();
    }

    private Board initializeBoard() {
        Board.initialize(setup.getBoardRows(), setup.getBoardCols());
        BoardBuilder builder = new BoardBuilder();
        builder.buildBoard(setup.getMineFrequency());
        return Board.getInstance();
    }

    public boolean hasWon() {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                Cell cell = board.getCell(new Position(row, col));
                if (cell != null && !cell.hasMine() && !cell.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
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
        return setup.getBoardCols();
    }

    public Cursor getCursor() { return cursor; }

    public int getCursorRow(){ return cursor.getPosition().getRow(); }

    public int getCursorCol(){ return cursor.getPosition().getCol(); }

    public GameClock getClock() { return clock; }

    public Cell getCell(Position position) { return board.getCell(position);}

}

