package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.game.Board;
import minesweeper.model.game.GameOver;
import minesweeper.view.GameOverViewer;
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

    @Test
    void testLoadContentAndSetsHasWon() {
        GameOver mockGameOver = mock(GameOver.class);
        GameOverViewer mockViewer = mock(GameOverViewer.class);
        StateFactory mockFactory = mock(StateFactory.class);

        GameOverState state = new GameOverState(mockGameOver, mockViewer, new GameSetup(10, 10, GameSetup.Difficulty.EASY), mockFactory);

        verify(mockGameOver, times(1)).loadContent(false);
        verify(mockGameOver, times(1)).setHasWon(false);
    }

    @Test
    void testReset() throws IOException {
        GameOver mockGameOver = mock(GameOver.class);
        GameOverViewer mockViewer = mock(GameOverViewer.class);
        StateFactory mockFactory = mock(StateFactory.class);
        MenuState mockMenuState = mock(MenuState.class);

        when(mockFactory.getMenuState(any(GameSetup.class))).thenReturn(mockMenuState);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);

        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ESCAPE);

        GameOverState state = new GameOverState(
                mockGameOver,
                mockViewer,
                new GameSetup(10, 10, GameSetup.Difficulty.EASY),
                mockFactory
        );

        Board.initialize(5,5);
        ControllerState<?> resultState = state.update(mockController, inputKey);

        verify(mockFactory).getMenuState(any(GameSetup.class));
        assertEquals(mockMenuState, resultState);
    }

}