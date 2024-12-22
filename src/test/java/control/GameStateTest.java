package control;

import control.state.ControllerState;
import control.state.GameOverState;
import control.state.GameState;
import control.state.StateFactory;
import model.GameSetup;
import model.Position;
import model.game.Board;
import model.game.Cell;
import model.game.Cursor;
import model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.game.GameViewer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameStateTest {

    private Game mockGame;
    private GameViewer mockViewer;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private GameState gameState;

    @BeforeEach
    void setUp() {
        mockGame = mock(Game.class);
        mockViewer = mock(GameViewer.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);

        Cursor mockCursor = mock(Cursor.class);
        when(mockGame.getCursor()).thenReturn(mockCursor);

        gameState = new GameState(mockGame, mockViewer, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockViewer, gameState.getViewer());
    }

    @Test
    void testMoveCursor() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.UP);

        gameState.update(mockController, inputKey);

        verify(mockGame.getCursor()).moveUp();
    }

    @Test
    void testRevealEmptyArea() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        Position position = mock(Position.class);
        when(mockGame.getCursor().getPosition()).thenReturn(position);

        Cell mockCell = mock(Cell.class);
        when(mockGame.getCell(position)).thenReturn(mockCell);
        when(mockGame.getCell(position).isRevealed()).thenReturn(false);
        when(mockGame.getCell(position).hasMine()).thenReturn(false);

        Board mockBoard = mock(Board.class);
        when(mockGame.getBoard()).thenReturn(mockBoard);

        gameState.update(mockController, inputKey);

        verify(mockGame.getBoard()).revealEmptyArea(position);
    }

    @Test
    void testGameOver() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        Position position = mock(Position.class);
        when(mockGame.getCursor().getPosition()).thenReturn(position);

        Cell mockCell = mock(Cell.class);
        when(mockGame.getCell(position)).thenReturn(mockCell);
        when(mockGame.getCell(position).hasMine()).thenReturn(true);

        GameOverState nextState = mock(GameOverState.class);
        when(mockFactory.getGameOverState(mockSetup)).thenReturn(nextState);

        ControllerState<?> result = gameState.update(mockController, inputKey);

        verify(mockFactory).getGameOverState(mockSetup);
        assertEquals(nextState, result);
    }
}