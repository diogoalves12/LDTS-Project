package model;

public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position pos) {
            return (row == pos.row && col == pos.col);
        }
        return false;
    }

    public String toString() {
        return "(" + row + "," + col + ")";
    }

}
