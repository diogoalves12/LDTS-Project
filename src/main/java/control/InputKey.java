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
        if (keyStroke == null) {
            return this;
        }

        InputMapper.mapKeyStroke(this, keyStroke);
        return this;
    }

    public void setInput(INPUT input) {
        this.input = input;
    }

    public void setKey(Character key) {
        this.key = key;
    }

}

