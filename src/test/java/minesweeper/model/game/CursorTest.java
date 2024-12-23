package minesweeper.model.game;

import minesweeper.model.game.Cursor;
import com.googlecode.lanterna.TerminalSize;
import minesweeper.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursorTest {

    @Test
    public void testCursorInitialization() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        assertEquals(initialPosition, cursor.getPosition());
    }

    @Test
    public void testMoveDownInBounds() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveDown();
        assertEquals(new Position(3, 3), cursor.getPosition());
    }

    @Test
    public void testMoveUpInBounds() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveUp();
        assertEquals(new Position(1, 3), cursor.getPosition());
    }

    @Test
    public void testMoveRightInBounds() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveRight();
        assertEquals(new Position(2, 4), cursor.getPosition());
    }

    @Test
    public void testMoveLeftInBounds() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveLeft();
        assertEquals(new Position(2, 2), cursor.getPosition());
    }

    @Test
    public void testMoveDownWrap() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(4, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveDown();
        assertEquals(new Position(0, 3), cursor.getPosition());
    }

    @Test
    public void testMoveUpWrapAround() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(0, 3);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveUp();
        assertEquals(new Position(4, 3), cursor.getPosition());
    }

    @Test
    public void testMoveRightWrapAround() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 4);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveRight();
        assertEquals(new Position(2, 0), cursor.getPosition());
    }

    @Test
    public void testMoveLeftWrapAround() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(2, 0);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveLeft();
        assertEquals(new Position(2, 4), cursor.getPosition());
    }

    @Test
    public void testCursorTopLeftCorner() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(0, 0);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveUp();
        cursor.moveLeft();
        assertEquals(new Position(4, 4), cursor.getPosition());
    }

    @Test
    public void testCursorBottomRightCorner() {
        TerminalSize size = new TerminalSize(5, 5);
        Position initialPosition = new Position(4, 4);
        Cursor cursor = new Cursor(size, initialPosition);

        cursor.moveDown();
        cursor.moveRight();
        assertEquals(new Position(0, 0), cursor.getPosition());
    }
}