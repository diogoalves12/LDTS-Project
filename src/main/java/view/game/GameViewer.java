package view.game;

import model.game.Game;
import view.View;
import view.ViewFactory;

import java.io.IOException;


public class GameViewer extends View<Game> {

    private BoardViewer boardViewer;
    private ClockViewer clockViewer;
    private CursorViewer cursorViewer;

    public GameViewer(Game model, ViewFactory factory) {
        super(model);
        setupScreen();

        this.boardViewer = factory.createBoardViewer(model.getBoard());
        this.clockViewer = factory.createClockView(model.getClock());
        this.cursorViewer = factory.createCursorView(model.getCursor());

        boardViewer.setScreen(this.screen);
        clockViewer.setScreen(this.screen);
        cursorViewer.setScreen(this.screen);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear();

        boardViewer.draw(col + 2,row + 5);
        clockViewer.draw(col + 2, row + 1);
        cursorViewer.draw(col +2, row + 5);

        refresh();
    }

}
