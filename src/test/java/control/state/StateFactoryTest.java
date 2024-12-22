package control.state;

import model.GameSetup;
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
        StateFactory factory = spy(new StateFactory());

        GameState mockState = mock(GameState.class);
        doReturn(mockState).when(factory).getGameState(setup);

        GameState result = factory.getGameState(setup);

        assertNotNull(result);
        assertEquals(mockState, result);
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

}