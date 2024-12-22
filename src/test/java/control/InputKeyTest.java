package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InputKeyTest {

    private InputKey inputKey;

    @BeforeEach
    void setUp() {
        inputKey = new InputKey();
    }

    @Test
    void testArrowUpInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowUp);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.UP, result.getInput());
    }

    @Test
    void testArrowDownInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.DOWN, result.getInput());
    }

    @Test
    void testArrowLeftInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowLeft);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.LEFT, result.getInput());
    }

    @Test
    void testArrowRightInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowRight);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.RIGHT, result.getInput());
    }

    @Test
    void testCharacterFInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke('f', false, false);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.FLAG, result.getInput());
        assertEquals('f', result.getKey());
    }


    @Test
    void testCharacterQInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke('q', false, false);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.QUIT, result.getInput());
        assertEquals('q', result.getKey());
    }

    @Test
    void testEscapeInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.Escape);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.ESCAPE, result.getInput());
    }

    @Test
    void testEnterInput() throws IOException {
        Screen screen = mock(Screen.class);
        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);
        when(screen.pollInput()).thenReturn(keyStroke);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.ENTER, result.getInput());
    }

    @Test
    void testNoInput() throws IOException {
        Screen screen = mock(Screen.class);
        when(screen.pollInput()).thenReturn(null);

        InputKey result = inputKey.processInput(screen);

        assertEquals(InputKey.INPUT.NONE, result.getInput());
    }
}