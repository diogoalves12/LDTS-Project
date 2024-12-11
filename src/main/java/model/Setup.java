package model;

public class Setup {
    public enum Difficulty {EASY, NORMAL, HARD}

    int boardRows, boardCols;
    Difficulty difficulty;

    public Setup(int boardRows, int boardCols, Difficulty difficulty) {
        this.boardRows = boardRows;
        this.boardCols = boardCols;
        this.difficulty = difficulty;
    }
    public int getBoardRows() {
        return boardRows;
    }

    public void setBoardRows(int boardRows) {
        this.boardRows = boardRows;
    }

    public int getBoardCols() {
        return boardCols;
    }

    public void setBoardCols(int boardCols) {
        this.boardCols = boardCols;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Setup getSetup(){
        return this;
    }

}
