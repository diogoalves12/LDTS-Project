package minesweeper.view.game;

import minesweeper.model.game.Game;
import minesweeper.view.View;
import minesweeper.view.ViewFactory;

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

        int terminalWidth = getSize().getColumns();
        int terminalHeight = getSize().getRows();

        int boardWidth = getModel().getBoard().getCols() * 2;
        int boardHeight = getModel().getBoard().getRows() + 1;

        int startX = (terminalWidth - boardWidth) / 2;
        int startY = (terminalHeight - boardHeight) / 2;


        boardViewer.draw(startX, startY);
        clockViewer.draw(col + 2, row + 1);
        cursorViewer.draw(startX, startY);

        refresh();
    }

}
