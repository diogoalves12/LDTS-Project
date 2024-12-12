package view;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    private Screen screen;
    private TextGraphics textGraphics;


    public Viewer(T model, Screen screen) {
        this.model = model;
        this.screen = screen;
        this.textGraphics = screen.newTextGraphics();
    }

    public T getModel() {
        return model;
    }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getTextGraphics() {
        return textGraphics;
    }

    public abstract void draw() throws IOException;

    protected void refreshScreen() throws IOException {
        screen.refresh();
    }
}


