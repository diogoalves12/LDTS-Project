package minesweeper.model.game;

import minesweeper.model.Position;
import minesweeper.model.game.Cell;
import minesweeper.model.game.MineCell;
import minesweeper.model.game.NormalCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testRevealCell() {
        Cell cell = new NormalCell(1, 1);

        assertFalse(cell.isRevealed());
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testRevealAlreadyRevealedCell() {
        Cell cell = new NormalCell(3, 3);

        cell.reveal();
        assertTrue(cell.isRevealed());
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testFlagCell() {
        Cell cell = new MineCell(2, 2);

        assertFalse(cell.isFlagged());
        cell.flag();
        assertTrue(cell.isFlagged());
    }

    @Test
    public void testToggleFlag() {
        Cell cell = new NormalCell(3, 3);

        assertFalse(cell.isFlagged());
        cell.toggleFlagged();
        assertTrue(cell.isFlagged());
        cell.toggleFlagged();
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testMultipleFlags() {
        Cell cell = new NormalCell(5, 5);

        assertFalse(cell.isFlagged());
        cell.flag();
        assertTrue(cell.isFlagged());
        cell.toggleFlagged();
        assertFalse(cell.isFlagged());
        cell.toggleFlagged();
        assertTrue(cell.isFlagged());
    }

    @Test
    public void testSetAndGetAdjacentMines() {
        Cell cell = new NormalCell(0, 0);

        cell.setAdjacentMines(3);
        assertEquals(3, cell.getAdjacentMines());
    }

    @Test
    public void testHasMine() {
        Cell normalCell = new NormalCell(1, 1);
        Cell mineCell = new MineCell(2, 2);

        assertFalse(normalCell.hasMine());
        assertTrue(mineCell.hasMine());
    }

    @Test
    public void testGetPosition() {
        Cell cell = new NormalCell(3, 3);
        Position position = cell.getPosition();
        assertEquals(3, cell.getRow());
        assertEquals(3, position.getCol());
    }

    @Test
    public void testGetRow() {
        Cell cell = new NormalCell(3, 3);
        assertEquals(3, cell.getRow());
    }

    @Test
    public void testGetCol() {
        Cell cell = new NormalCell(3, 3);
        assertEquals(3, cell.getCol());
    }

}


