package view.game;

import model.Position;
import model.game.Board;
import view.View;
import view.ViewFactory;

import java.io.IOException;

public class BoardViewer extends View<Board> {
    private CellViewer viewer;

    public BoardViewer(Board board) {
        super(board);
    }

    @Override
    public void draw() throws IOException {
        int terminalWidth = getSize().getColumns();
        int terminalHeight = getSize().getRows();

        int boardWidth = getModel().getCols() * 2;
        int boardHeight = getModel().getRows() + 1;
        int startX = (terminalWidth - boardWidth) / 2;
        int startY = (terminalHeight - boardHeight) / 2;


        for (int row = 0; row < getModel().getRows(); row++) {
            for (int col = 0; col < getModel().getCols(); col++) {
                Position position = new Position(row, col);
                viewer = ViewFactory.createCellView(getModel().getCell(position));
                viewer.setScreen(getScreen());


                viewer.draw();
            }

        }

    }
}