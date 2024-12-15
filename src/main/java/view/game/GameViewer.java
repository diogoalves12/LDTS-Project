package view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.game.Game;
import view.View;

import java.io.IOException;

import static view.ViewFactory.*;

public class GameViewer extends View<Game> {

    public GameViewer(Game model) {
        super(model);
        setupScreen();
    }

    @Override
    public void draw() throws IOException {

        clear();

        createBoardViewer(getModel().getBoard()).draw();
        createClockView(getModel().getClock()).draw();
        createCursorView(getModel().getCursor()).draw();

        refresh();
    }
}
