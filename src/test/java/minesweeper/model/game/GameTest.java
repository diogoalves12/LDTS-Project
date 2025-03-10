package minesweeper.model.game;

import minesweeper.model.GameSetup;
import minesweeper.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    private GameSetup mockSetup;
    private Board mockBoard;
    private Game game;

    @BeforeEach
    public void setUp() {
        mockSetup = mock(GameSetup.class);
        mockBoard = mock(Board.class);

        when(mockSetup.getBoardRows()).thenReturn(10);
        when(mockSetup.getBoardCols()).thenReturn(10);
        when(mockSetup.getMineFrequency()).thenReturn(6);

        game = new Game(mockSetup);
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(game.getBoard());
        assertNotNull(game.getCursor());
        assertNotNull(game.getClock());
        assertTrue(game.getClock().isRunning());
    }

    @Test
    public void testBoardSetup() {
        assertEquals(10, game.getRows());
        assertEquals(10, game.getColumns());
    }

    @Test
    public void testCursorInitialization() {
        Cursor cursor = game.getCursor();
        assertNotNull(cursor);
        assertEquals(0, cursor.getPosition().getRow());
        assertEquals(0, cursor.getPosition().getCol());
    }

    @Test
    public void testCursorMethods() {
        int row = game.getCursorRow();
        int col = game.getCursorCol();
        assertEquals(0, row);
        assertEquals(0, col);
    }

    @Test
    public void testGetCell() {
        Position position = new Position(3, 3);
        Cell mockCell = mock(Cell.class);

        when(mockBoard.getCell(position)).thenReturn(mockCell);

        Cell cell = game.getCell(position);
        assertNotNull(cell);
    }

    @Test
    public void testClockRunning() {
        assertNotNull(game.getClock());
        assertTrue(game.getClock().isRunning());
    }

    @Test
    public void testHasWonFalse() {
        when(mockBoard.getRows()).thenReturn(10);
        when(mockBoard.getCols()).thenReturn(10);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Position position = new Position(row, col);
                Cell mockCell = mock(Cell.class);

                if (row == 0 && col == 0) {
                    when(mockCell.hasMine()).thenReturn(false);
                    when(mockCell.isRevealed()).thenReturn(false);
                } else {
                    when(mockCell.hasMine()).thenReturn(false);
                    when(mockCell.isRevealed()).thenReturn(true);
                }

                when(mockBoard.getCell(position)).thenReturn(mockCell);
            }
        }

        assertFalse(game.hasWon());
    }


    @Test
    public void testGetSetup() {
        assertEquals(mockSetup, game.getSetup());
    }

    @Test
    public void testGetCursorRow() {
        assertEquals(0, game.getCursorRow());
    }

    @Test
    public void testGetCursorCol() {
        assertEquals(0, game.getCursorCol());
    }

}