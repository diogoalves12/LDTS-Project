package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.control.state.ControllerState;
import minesweeper.control.state.GameOverState;
import minesweeper.control.state.MenuState;
import minesweeper.control.state.StateFactory;
import minesweeper.model.GameSetup;
import minesweeper.model.game.Board;
import minesweeper.model.game.GameOver;
import minesweeper.view.game.GameOverViewer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverStateTest {

    private GameOverViewer mockViewer;
    private GameOver mockGameOver;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private GameOverState gameOverState;

    @BeforeEach
    void setUp() {
        mockViewer = mock(GameOverViewer.class);
        mockGameOver = mock(GameOver.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);

        gameOverState = new GameOverState(mockGameOver, mockViewer, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockViewer, gameOverState.getViewer());
    }

    @Test
    void testUpdateESCAPE() throws IOException {
        Board.initialize(5,5);
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(mockSetup)).thenReturn(mockMenuState);
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ESCAPE);

        ControllerState<?> result = gameOverState.update(mockController, inputKey);

        verify(mockFactory).getMenuState(mockSetup);
        assertEquals(mockMenuState, result);
    }

    @Test
    void testUpdateUnHandledInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = gameOverState.update(mockController, inputKey);

        assertEquals(gameOverState, result);
        verifyNoInteractions(mockFactory);
    }

}