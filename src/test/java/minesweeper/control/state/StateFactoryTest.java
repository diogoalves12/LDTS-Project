package minesweeper.control.state;

import minesweeper.model.GameSetup;
import minesweeper.model.game.Game;
import minesweeper.view.GameViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StateFactoryTest {

    @Test
    public void testGetMenuState() {
        StateFactory factory = new StateFactory();
        GameSetup setup = mock(GameSetup.class);

        MenuState result = factory.getMenuState(setup);

        assertNotNull(result);
        assertNotNull(result.factory);
        assertEquals(setup, result.setup);
    }

    @Test
    void testGetGameState() {
        GameSetup setup = mock(GameSetup.class);
        StateFactory factory = mock(StateFactory.class);

        Game mockGame = mock(Game.class);
        GameViewer mockViewer = mock(GameViewer.class);

        when(factory.getGameState(setup)).thenReturn(new GameState(mockGame, mockViewer, setup, factory));

        GameState result = factory.getGameState(setup);

        assertNotNull(result);
        assertNotNull(result.game);
        assertNotNull(result.viewer);
        assertEquals(setup, result.setup);
    }


    @Test
    void testGetHelpState() {
        StateFactory factory = new StateFactory();
        GameSetup setup = mock(GameSetup.class);

        HelpState result = factory.getHelpState(setup);

        assertNotNull(result);
        assertNotNull(result.factory);
        assertEquals(setup, result.setup);
    }

   @Test
    void testGetGameOverState() {
        StateFactory factory = new StateFactory();
        GameSetup setup = mock(GameSetup.class);

        GameOverState result = factory.getGameOverState(setup);

        assertNotNull(result);
        assertNotNull(result.factory);
        assertEquals(setup, result.setup);
    }

    @Test
    void testGetGameWinState() {
        StateFactory factory = new StateFactory();
        GameSetup setup = mock(GameSetup.class);

        GameWinState result = factory.getGameWinState(setup);

        assertNotNull(result);
        assertNotNull(result.factory);
        assertEquals(setup, result.setup);
    }

}