package model.game;

import model.Position;

public class Cursor {
    private int row;
    private int col;

    public Cursor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position getPosition() {
        return  new Position(row,col);
    }

    public void moveUp() { row--; }

    public void moveDown() { row++; }

    public void moveLeft() { col--; }

    public void moveRight() { col++; }

    public int getRow() { return row; }

    public int getCol() { return col; }

}
