package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import control.InputKey;

import java.io.IOException;

public abstract class View<T> {
    private final T model;
    protected Screen screen;
    protected TextGraphics graphics;

    public static final int WIDTH = 60;
    public static final int HEIGHT = 35;


    public View(T model) {
        this.model = model;
    }

    public void setupScreen(){
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(getSize());
            Terminal terminal = factory.createTerminal();
            screen = new TerminalScreen(terminal);

            initializeScreen();
            graphics = screen.newTextGraphics();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initializeScreen() throws IOException {
            screen.startScreen();
            screen.setCursorPosition(null);
            screen.doResizeIfNecessary();
    }

    public TerminalSize getSize(){ return new TerminalSize(WIDTH,HEIGHT); }

    public T getModel() { return model; }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        if(graphics == null) setupScreen();
        return graphics;
    }

    public abstract void draw() throws IOException;

    protected void refresh() throws IOException {
        screen.refresh();
    }

    protected void clear() throws IOException{
        screen.clear();
    }

    public void close() throws IOException {
        if(screen != null) screen.close();
    }

    public InputKey getCommand() throws IOException {
        return new InputKey().processInput(screen);
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
        this.graphics = screen.newTextGraphics();
    }
}


