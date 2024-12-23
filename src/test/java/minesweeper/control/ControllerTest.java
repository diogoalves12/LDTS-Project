package minesweeper.control;

import minesweeper.control.Controller;
import minesweeper.control.state.ControllerState;
import minesweeper.control.state.MenuState;
import minesweeper.control.state.StateFactory;
import minesweeper.model.GameSetup;
import minesweeper.model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static minesweeper.model.GameSetup.Difficulty.NORMAL;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private StateFactory mockFactory;
    private ControllerState<Object> mockState;
    private Game mockGame;
    private GameSetup setup;

    @BeforeEach
    void setUp() {
        mockFactory = mock(StateFactory.class);
        mockState = mock(ControllerState.class);
        mockGame = mock(Game.class);
        setup = new GameSetup(14, 14, NORMAL);
    }

    @Test
    void testInitializeState() {
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(any(GameSetup.class))).thenReturn(mockMenuState);

        Controller controller = new Controller(mockFactory);

        assertNotNull(controller.state);
        verify(mockFactory).getMenuState(any(GameSetup.class));
    }

    @Test
    void testSetAndGetGame() {
        Controller controller = new Controller(mockFactory);

        controller.setGame(mockGame);

        assertEquals(mockGame, controller.getGame());
    }

    @Test
    void testLaunch() throws IOException, InterruptedException {
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(any())).thenReturn(mockMenuState);

        Controller controller = new Controller(mockFactory);

        when(mockMenuState.processInput()).thenReturn(null);
        when(mockMenuState.update(eq(controller), isNull())).thenReturn(null);

        controller.launch();

        verify(mockMenuState, times(1)).processInput();
        verify(mockMenuState, times(1)).update(eq(controller), isNull());

        assertNull(controller.state);
    }
}