package model.game;

public abstract class Cell {

    private boolean isRevealed;
    private boolean isFlagged;
    private final int row;
    private final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.isRevealed = false;
        this.isFlagged = false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        if (!isRevealed) {
            isRevealed = true;
        }
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void flag() {
        if(!isFlagged()) {
            isFlagged = true;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public abstract boolean hasMine();

}
