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
        fillBackground(col, row);

        for (int x = 0; x < getModel().getRows(); x++) {
            for (int y = 0; y < getModel().getCols(); y++) {
                Position position = new Position(x, y);
                viewer = ViewFactory.createCellView(getModel().getCell(position));
                viewer.setScreen(getScreen());


                viewer.draw(col + y * 2, row + x);
            }
        }
    }

    private void fillBackground(int col, int row) {
        int terminalWidth = getSize().getColumns();
        int terminalHeight = getSize().getRows();

        graphics.setBackgroundColor(TextColor.Factory.fromString("#2E3B44"));

        for (int x = 0; x < terminalHeight; x++) {
            for (int y = 0; y < terminalWidth; y++) {
                graphics.putString(y, x, " ");
            }
        }
    }
}