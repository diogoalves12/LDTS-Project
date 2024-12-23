package minesweeper.model;

import minesweeper.model.Position;
import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Property
    public void testValidPosition(@ForAll int row, @ForAll int col) {
        Position pos = new Position(row, col);
        assertEquals(row, pos.getRow());
        assertEquals(col, pos.getCol());
    }

    @Property
    public void testToStringMethod(@ForAll int row, @ForAll int col) {
        Position pos = new Position(row, col);
        assertEquals("(" + row + "," + col+ ")", pos.toString());
    }

}
