package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.Position;
import minesweeper.model.game.Board;
import minesweeper.model.game.Cell;
import minesweeper.model.game.Cursor;
import minesweeper.model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import minesweeper.view.game.GameViewer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameStateTest {

    private Game mockGame;
    private GameViewer mockViewer;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private GameState gameState;

    private Cursor mockCursor;
    private Cell mockCell;
    private Board mockBoard;

    @BeforeEach
    void setUp() {
        mockGame = mock(Game.class);
        mockViewer = mock(GameViewer.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);

        mockCursor = mock(Cursor.class);
        when(mockGame.getCursor()).thenReturn(mockCursor);

        mockCell = mock(Cell.class);
        mockBoard = mock(Board.class);

        gameState = new GameState(mockGame, mockViewer, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockViewer, gameState.getViewer());
    }

    @Test
    void testMoveCursorUP() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.UP);

        gameState.update(mockController, inputKey);

        verify(mockCursor).moveUp();
    }

    @Test
    void testMoveCursorDown() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.DOWN);

        gameState.update(mockController, inputKey);

        verify(mockCursor).moveDown();
    }

    @Test
    void testRevealEmptyArea() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        Position position = mock(Position.class);
        when(mockCursor.getPosition()).thenReturn(position);

        when(mockGame.getCell(position)).thenReturn(mockCell);
        when(mockCell.isRevealed()).thenReturn(false);
        when(mockCell.hasMine()).thenReturn(false);

        when(mockGame.getBoard()).thenReturn(mockBoard);

        gameState.update(mockController, inputKey);

        verify(mockBoard).revealEmptyArea(position);
    }

    @Test
    void testGameLost() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        Position position = mock(Position.class);
        when(mockCursor.getPosition()).thenReturn(position);

        when(mockGame.getCell(position)).thenReturn(mockCell);
        when(mockCell.hasMine()).thenReturn(true);

        GameOverState nextState = mock(GameOverState.class);
        when(mockFactory.getGameOverState(mockSetup)).thenReturn(nextState);

        ControllerState<?> result = gameState.update(mockController, inputKey);

        verify(mockFactory).getGameOverState(mockSetup);
        assertEquals(nextState, result);
    }

    @Test
    void testGameWon() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        Position position = mock(Position.class);
        when(mockCursor.getPosition()).thenReturn(position);
        when(mockGame.getCell(position)).thenReturn(mockCell);
        when(mockCell.isRevealed()).thenReturn(false);
        when(mockCell.hasMine()).thenReturn(false);

        when(mockGame.getBoard()).thenReturn(mockBoard);

        when(mockGame.hasWon()).thenReturn(true);

        GameWinState mockGameWinState = mock(GameWinState.class);
        when(mockFactory.getGameWinState(mockSetup)).thenReturn(mockGameWinState);

        ControllerState<?> result = gameState.update(mockController, inputKey);

        verify(mockFactory).getGameWinState(mockSetup);
        assertEquals(mockGameWinState, result);
    }

    @Test
    void testToggleFlag() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.FLAG);

        Position position = mock(Position.class);
        when(mockCursor.getPosition()).thenReturn(position);
        when(mockGame.getCell(position)).thenReturn(mockCell);

        gameState.update(mockController, inputKey);

        verify(mockCell).toggleFlagged();
    }

    @Test
    void testEscapeToMenu() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ESCAPE);

        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(mockSetup)).thenReturn(mockMenuState);

        ControllerState<?> result = gameState.update(mockController, inputKey);

        verify(mockFactory).getMenuState(mockSetup);
        assertEquals(mockMenuState, result);
    }

}