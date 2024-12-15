package view.game;

import model.game.Board;
import model.game.Game;
import view.View;

import java.io.IOException;

import static view.ViewFactory.*;

public class GameViewer extends View<Game> {
    private BoardViewer boardViewer;
    private ClockViewer clockViewer;
    private CursorViewer cursorViewer;

    public GameViewer(Game model) {
        super(model);
        setupScreen();

        this.boardViewer = createBoardViewer(model.getBoard());
        this.clockViewer = createClockView(model.getClock());
        this.cursorViewer = createCursorView(model.getCursor());

        boardViewer.setScreen(this.screen);
        clockViewer.setScreen(this.screen);
        cursorViewer.setScreen(this.screen);
    }

    @Override
    public void draw() throws IOException {
        clear();

        boardViewer.draw();
        clockViewer.draw();
        cursorViewer.draw();

        refresh();
    }
}
