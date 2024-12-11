package model;

public class Cell {
    private boolean hasMine;
    private boolean revealed;
    private boolean flagged;
    private int adjacentMines;

    public Cell(boolean hasMine, boolean revealed, boolean flagged) {
        this.hasMine = hasMine;
        this.revealed = revealed;
        this.flagged = flagged;
        this.adjacentMines = 0;
    }

    public Cell() {
        this.hasMine = false;
        this.revealed = false;
        this.flagged = false;
        this.adjacentMines = 0;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

}
