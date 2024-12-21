package model.game;

import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testBoardSize(){
        Board.initialize(20,20);
        Board board = Board.getInstance();

        assertEquals(20, board.getRows());
        assertEquals(20, board.getCols());
    }

    @Test
    public void testInitialization(){
        Board.initialize(20,20);
        Board board1 = Board.getInstance();
        Board board2 = Board.getInstance();

        assertNotNull(board1);
        assertEquals(board1, board2);
    }

    @Test
    public void testCellsInitialization() {
        Board.initialize(10,10);
        Board board = Board.getInstance();

        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                Position position = new Position(x, y);
                Cell cell = board.getCell(position);
                assertNotNull(cell);
                assertFalse(cell.isRevealed());
                assertFalse(cell.isFlagged());
                assertFalse(cell.hasMine());
                assertEquals(position, cell.getPosition());
            }
        }
    }

    @Test
    public void testAddCell(){
        Board.initialize(5,5);
        Board board = Board.getInstance();

        Cell cell = CellFactory.createCell(true, 2, 2);
        board.addCell(new Position(2,2), cell);

        assertEquals(cell, board.getCell(new Position(2,2)));
    }

    @Test
    public void testCountAdjacentMines() {
        Board.initialize(5,5);
        Board board = Board.getInstance();

        board.addCell(new Position(0,0), CellFactory.createCell(true, 0, 0));
        board.addCell(new Position(0,1), CellFactory.createCell(true, 0, 1));
        board.addCell(new Position(1,1), CellFactory.createCell(false, 1, 1));

        int adjacentMines = board.countAdjacentMines(new Position(1,1));
        assertEquals(2, adjacentMines);
    }


}
