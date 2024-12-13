package view;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    protected Screen screen;
    protected TextGraphics graphics;


    public Viewer(T model, Screen screen) {
        this.model = model;
        this.screen = screen;
        this.graphics = initializeGraphics(screen);
    }

    public T getModel() {
        return model;
    }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    protected TextGraphics initializeGraphics(Screen screen){
        return screen.newTextGraphics();
    }

    public abstract void draw() throws IOException;

    protected void refresh() throws IOException {
        screen.refresh();
    }
}


