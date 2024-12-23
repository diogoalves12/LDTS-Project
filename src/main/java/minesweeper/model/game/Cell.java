package minesweeper.model.game;

import minesweeper.model.Position;

public abstract class Cell {

    private final Position position;
    private boolean isRevealed = false;
    private boolean isFlagged = false;
    private int adjacentMines;

    public Cell(int row, int col) {
        this.position = new Position(row, col);
    }

    public void reveal() {
        if (!isRevealed) {
            isRevealed = true;
        }
    }

    public void flag() {
        if(!isFlagged()) {
            isFlagged = true;
        }
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlagged() {
        isFlagged = !isFlagged;
    }

    public Position getPosition() {
        return position;
    }

    public int getRow() { return position.getRow(); }

    public int getCol() {return position.getCol(); }

    public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines;}

    public int getAdjacentMines() { return adjacentMines; }

    public abstract boolean hasMine();

}
