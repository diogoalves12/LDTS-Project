package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControllerStateTest {

    private GameSetup mockSetup;
    private StateFactory mockFactory;
    private View<Object> mockView;

    @BeforeEach
    void setup() {
        mockSetup = mock(GameSetup.class);
        mockFactory = mock(StateFactory.class);
        mockView = mock(View.class);
    }

    static class TestControllerState extends ControllerState<Object> {
        private final View<Object> testView;

        public TestControllerState(GameSetup setup, StateFactory factory, View<Object> view) {
            super(setup, factory);
            this.testView = view;
        }

        @Override
        public View<Object> getViewer() {
            return testView;
        }

        @Override
        public ControllerState<?> update(Controller controller, InputKey inputKey) {
            return this;
        }

    }

    @Test
    void testDraw() throws IOException {
        ControllerState<Object> state = new TestControllerState(mockSetup, mockFactory, mockView);

        doNothing().when(mockView).draw(0, 0);

        state.draw();

        verify(mockView).draw(0, 0);
    }

    @Test
    void testProcessInput() throws IOException {
        ControllerState<Object> state = new TestControllerState(mockSetup, mockFactory, mockView);

        when(mockView.getScreen()).thenReturn(null);
        doNothing().when(mockView).setupScreen();
        doNothing().when(mockView).draw(0, 0);
        InputKey fakeInputKey = mock(InputKey.class);
        when(mockView.getCommand()).thenReturn(fakeInputKey);

        InputKey returnedKey = state.processInput();

        verify(mockView).setupScreen();
        verify(mockView).draw(0, 0);
        verify(mockView, times(1)).getCommand();

        assertEquals(fakeInputKey, returnedKey);
    }

    @Test
    void testChangeState() throws IOException {
        View<Object> mockView1 = mock(View.class);
        View<Object> mockView2 = mock(View.class);

        ControllerState<Object> currentState = new TestControllerState(mockSetup, mockFactory, mockView1);
        ControllerState<Object> nextState = new TestControllerState(mockSetup, mockFactory, mockView2);

        doNothing().when(mockView1).close();

        ControllerState<?> resultState = currentState.changeState(nextState);

        verify(mockView1).close();
        assertEquals(nextState, resultState);
    }
}