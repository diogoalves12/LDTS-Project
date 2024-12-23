package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.control.state.ControllerState;
import minesweeper.control.state.HelpState;
import minesweeper.control.state.MenuState;
import minesweeper.control.state.StateFactory;
import minesweeper.model.GameSetup;
import minesweeper.model.help.HelpModel;
import minesweeper.view.help.HelpPageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HelpStateTest {

    private HelpModel mockHelpModel;
    private HelpPageView mockViewer;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private HelpState helpState;

    @BeforeEach
    void setUp() {
        mockHelpModel = mock(HelpModel.class);
        mockViewer = mock(HelpPageView.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);

        helpState = new HelpState(mockHelpModel, mockViewer, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockViewer, helpState.getViewer());
    }

    @Test
    void testEscapeInput() throws IOException {
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(mockSetup)).thenReturn(mockMenuState);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ESCAPE);

        ControllerState<?> result = helpState.update(mockController, inputKey);

        verify(mockFactory).getMenuState(mockSetup);
        assertEquals(mockMenuState, result);
    }

    @Test
    void testLeftInput() throws IOException {
        MenuState mockMenuState = mock(MenuState.class);
        when(mockFactory.getMenuState(mockSetup)).thenReturn(mockMenuState);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.LEFT);

        ControllerState<?> result = helpState.update(mockController, inputKey);

        verify(mockFactory).getMenuState(mockSetup);
        assertEquals(mockMenuState, result);
    }

    @Test
    void testQuitInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.QUIT);

        ControllerState<?> result = helpState.update(mockController, inputKey);

        assertNull(result);
    }

    @Test
    void testUnHandledInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = helpState.update(mockController, inputKey);

        assertEquals(helpState, result);
        verifyNoInteractions(mockFactory);
    }

}