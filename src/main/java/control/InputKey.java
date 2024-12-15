package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class InputKey {
    public enum INPUT {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        ENTER,
        FLAG,
        ESCAPE,
        NONE,
        QUIT,
    }

    private INPUT input;
    private Character key;

    public InputKey() {
        this.input = INPUT.NONE;
        this.key = ' ';
    }

    public INPUT getInput() {
        return input;
    }

    public Character getKey() {
        return key;
    }

    public InputKey processInput(Screen screen) throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return this;

        processKeyStroke(keyStroke);
        return this;
    }

    private void processKeyStroke(KeyStroke keyStroke) {
        switch (keyStroke.getKeyType()) {
            case EOF -> this.input = INPUT.QUIT;
            case ArrowUp -> this.input = INPUT.UP;
            case ArrowDown -> this.input = INPUT.DOWN;
            case ArrowLeft -> this.input = INPUT.LEFT;
            case ArrowRight -> this.input = INPUT.RIGHT;
            case Enter -> this.input = INPUT.ENTER;
            case Escape -> this.input = INPUT.ESCAPE;
            case Character -> handleCharacterInput(keyStroke.getCharacter());
        }
    }

    private void handleCharacterInput(Character character) {
        this.key = character;
        switch (character) {
            case 'f' -> this.input = INPUT.FLAG;
            case 'q' -> this.input = INPUT.QUIT;
            default -> this.input = INPUT.NONE;
        }
    }
}