package model;

public class GameSetup {
    public enum Difficulty {
        EASY,
        NORMAL,
        HARD
    }

    int boardRows, boardCols;
    private int mineFrequency;
    Difficulty difficulty;

    public GameSetup(int boardRows, int boardCols, int mineFrequency ,Difficulty difficulty) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        this.mineFrequency = mineFrequency;
        this.difficulty = difficulty;
    }

    public GameSetup(Difficulty difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case EASY: {
                this.boardRows = 8;
                this.boardCols = 8;
                break;
            }
            case NORMAL: {
                this.boardRows = 14;
                this.boardCols = 14;
                break;
            }
            case HARD: {
                this.boardRows = 20;
                this.boardCols = 20;
                break;
            }
        }
    }


    public int getMineFrequency() {
        return switch (difficulty) {
            case EASY -> 8;
            case NORMAL -> 6;
            case HARD -> 5;
        };
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


}


