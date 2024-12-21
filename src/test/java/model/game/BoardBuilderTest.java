package model.game;

import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardBuilderTest {

    @Test
    public void testBoardInitialize() {
        Board.initialize(5, 5);
        BoardBuilder boardBuilder = new BoardBuilder();

        boardBuilder.buildBoard(0); // garante que nao existe minas
        Board board = Board.getInstance();

        int rows = board.getRows();
        int cols = board.getCols();

        assertEquals(rows * cols, board.countCells());
    }

    @Test
    public void testMinesCount() {
        Board.initialize(10, 10);
        BoardBuilder boardBuilder = new BoardBuilder();

        int freq = 6;
        boardBuilder.buildBoard(freq);

        Board board = Board.getInstance();
        int mines = board.countMines();

        assertTrue(board.countMines() > 0);
        assertTrue(board.countMines() < board.getCols() * board.getRows());
        assertTrue(board.countMines() < board.countCells());
    }

    @Test
    public void testCellsInitialization() {
        Board.initialize(10, 10);
        BoardBuilder boardBuilder = new BoardBuilder();
        boardBuilder.buildBoard(0);
        Board board = Board.getInstance();

        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                Position position = new Position(x, y);
                Cell cell = board.getCell(position);
                assertNotNull(cell);
                assertFalse(cell.isRevealed());
                assertFalse(cell.isFlagged());
            }
        }
    }


}
