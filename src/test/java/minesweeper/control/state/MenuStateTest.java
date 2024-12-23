package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.control.state.*;
import minesweeper.model.GameSetup;
import minesweeper.model.menu.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import minesweeper.view.menu.MenuView;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {

    private MenuModel mockModel;
    private MenuView mockView;
    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private MenuState menuState;

    @BeforeEach
    void setUp() {
        mockModel = mock(MenuModel.class);
        mockView = mock(MenuView.class);
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);
        menuState = new MenuState(mockModel, mockView, mockSetup, mockFactory);
    }

    @Test
    void testGetViewer() {
        assertEquals(mockView, menuState.getViewer());
    }

    @Test
    void testUpInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.UP);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockModel).previousOption();
        assertEquals(menuState, result);
    }

    @Test
    void testDownInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.DOWN);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockModel).nextOption();
        assertEquals(menuState, result);
    }

    @Test
    void testLeftInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.LEFT);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockModel).previousDifficulty();
        assertEquals(menuState, result);
    }

    @Test
    void testRightInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.RIGHT);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockModel).nextDifficulty();
        assertEquals(menuState, result);
    }

    @Test
    void testEnterPlayOption() throws IOException {
        GameState mockGameState = mock(GameState.class);

        when(mockModel.getSelected()).thenReturn(0);
        when(mockModel.getDifficulty()).thenReturn(GameSetup.Difficulty.NORMAL);
        when(mockFactory.getGameState(any(GameSetup.class))).thenReturn(mockGameState);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockFactory).getGameState(any());
        assertNotEquals(menuState, result);
    }

    @Test
    void testEnterHelpOption() throws IOException {
        HelpState mockState = mock(HelpState.class);

        when(mockModel.getSelected()).thenReturn(1);
        when(mockFactory.getHelpState(mockSetup)).thenReturn(mockState);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        verify(mockFactory).getHelpState(mockSetup);
        assertNotEquals(menuState, result);
    }

    @Test
    void testEnterQuitOption() throws IOException {
        when(mockModel.getSelected()).thenReturn(2);

        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.ENTER);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        assertNull(result);
    }

    @Test
    void testQuitInput() throws IOException {
        Controller mockController = mock(Controller.class);
        InputKey inputKey = mock(InputKey.class);
        when(inputKey.getInput()).thenReturn(InputKey.INPUT.QUIT);

        ControllerState<?> result = menuState.update(mockController, inputKey);

        assertNull(result);
    }

}