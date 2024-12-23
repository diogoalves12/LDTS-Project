package minesweeper.model.game;

import com.googlecode.lanterna.TerminalSize;
import minesweeper.model.Position;

public class Cursor {
    Position position;
    TerminalSize size;

    public Cursor(TerminalSize size, Position position) {
        this.position = position;
        this.size = size;
    }

    public Position getPosition() {
        return  position;
    }

    public void moveDown() {
        int row = (position.getRow() + 1) % size.getRows();
        position = new Position(row, position.getCol());
    }

    public void moveUp() {
        int row = ((position.getRow() - 1) + size.getRows()) % size.getRows();
        position = new Position(row, position.getCol());
    }


    public void moveRight() {
        int col = (position.getCol() + 1) % size.getColumns();
        position = new Position(position.getRow(), col);
    }

    public void moveLeft() {
        int col = ((position.getCol() - 1) + size.getColumns()) % size.getColumns();
        position = new Position(position.getRow(), col);
    }
}
