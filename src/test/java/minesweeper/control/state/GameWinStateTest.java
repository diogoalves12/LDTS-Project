package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.game.GameOver;
import minesweeper.view.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GameWinStateTest {

    private GameOverViewer mockViewer;
    private GameOver mockGameOver;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private GameWinState gameWinState;

    @BeforeEach
    void setUp() {
        mockViewer = mock(GameOverViewer.class);
        mockGameOver = mock(GameOver.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);

        gameWinState = new GameWinState(mockGameOver, mockViewer, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockViewer, gameWinState.getViewer());
    }

    @Test
    void testESCAPE() throws IOException {
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(mockSetup)).thenReturn(mockMenuState);
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ESCAPE);

        ControllerState<?> result = gameWinState.update(mockController, inputKey);

        verify(mockFactory).getMenuState(mockSetup);
        assertEquals(mockMenuState, result);
    }

    @Test
    void testQUIT() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.QUIT);

        ControllerState<?> result = gameWinState.update(mockController, inputKey);

        assertNull(result);
    }

    @Test
    void testUnhandledInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = gameWinState.update(mockController, inputKey);

        assertEquals(gameWinState, result);
        verifyNoInteractions(mockFactory);
    }

    @Test
    void testLoadContentAndSetsHasWon() {
        verify(mockGameOver, times(1)).loadContent(true);
        verify(mockGameOver, times(1)).setHasWon(true);
    }
}