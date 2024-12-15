package model;

public class GameSetup {
    public enum Difficulty {EASY, NORMAL, HARD}

    int boardRows, boardCols;
    Difficulty difficulty;

    public GameSetup(int boardRows, int boardCols, Difficulty difficulty) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        this.difficulty = difficulty;
    }

    public int getBoardRows() {
        return boardRows;
    }

    public int getBoardCols() {
        return boardCols;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getMineFrequency() {
        return switch (difficulty) {
            case EASY -> 8;
            case NORMAL -> 6;
            case HARD -> 5;
        };
    }

}


