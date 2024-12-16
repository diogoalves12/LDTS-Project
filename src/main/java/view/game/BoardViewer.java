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
    public void draw(int col, int row) throws IOException {
        int terminalWidth = getSize().getColumns();
        int terminalHeight = getSize().getRows();

        int boardWidth = getModel().getCols() * 2;
        int boardHeight = getModel().getRows() + 1;
        int startX = (terminalWidth - boardWidth) / 2;
        int startY = (terminalHeight - boardHeight) / 2;


        for (int x = 0; x < getModel().getRows(); x++) {
            for (int y = 0; y < getModel().getCols(); y++) {
                Position position = new Position(x, y);
                viewer = ViewFactory.createCellView(getModel().getCell(position));
                viewer.setScreen(getScreen());


                viewer.draw(y * 2 + col, x + row);
            }

        }

    }
}