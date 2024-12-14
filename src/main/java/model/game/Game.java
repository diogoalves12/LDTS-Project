package model.game;

import model.GameSetup;

public class Game {

    private final Board board;
    private final GameSetup setup;

    public Game(GameSetup setup) {
        this.setup = setup;
        int freq = calculateMineFrequency();

        Board.initialize(setup.getBoardRows(), setup.getBoardCols());
        BoardBuilder builder = new BoardBuilder(null);
        builder.buildBoard(freq);

        this.board = Board.getInstance();
    }

    private int calculateMineFrequency(){
        return switch (setup.getDifficulty()) {
            case EASY -> 8;
            case NORMAL -> 6;
            case HARD -> 5;
            default -> throw new IllegalArgumentException("Invalid difficulty");
        };
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

}

