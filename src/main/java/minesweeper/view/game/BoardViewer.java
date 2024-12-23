package minesweeper.view.game;

import minesweeper.model.Position;
import minesweeper.model.game.Board;
import minesweeper.view.View;
import minesweeper.view.ViewFactory;

import java.io.IOException;

public class BoardViewer extends View<Board> {
    private CellViewer viewer;

    public BoardViewer(Board board) {
        super(board);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        fillBackground();

        for (int x = 0; x < getModel().getRows(); x++) {
            for (int y = 0; y < getModel().getCols(); y++) {
                Position position = new Position(x, y);
                viewer = ViewFactory.createCellView(getModel().getCell(position));
                viewer.setScreen(getScreen());


                viewer.draw(col + y * 2, row + x);
            }
        }
    }

}