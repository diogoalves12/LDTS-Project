package view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.Setup;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    private Screen screen;
    private TextGraphics textGraphics;


    protected Viewer(T model, Screen screen) {
        this.model = model;
    }

    public void drawScreen(){
        try {
            TerminalSize size = new TerminalSize(50, 25);

            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(size);
            Terminal terminal = terminalFactory.createTerminal();

            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            textGraphics = screen.newTextGraphics();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public T getModel() {
        return model;
    }

    public void draw() throws IOException {

    }



}


