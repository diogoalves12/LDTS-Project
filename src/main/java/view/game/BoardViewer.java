package view.game;

import com.googlecode.lanterna.TextColor;
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