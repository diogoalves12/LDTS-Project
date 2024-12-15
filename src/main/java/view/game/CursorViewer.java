package view.game;

import com.googlecode.lanterna.TextColor;
import model.game.Cursor;
import view.View;

import java.io.IOException;

public class CursorViewer extends View<Cursor> {

    public CursorViewer(Cursor model) {
        super(model);
    }

    @Override
    public void draw() throws IOException {

        graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));

        int row = getModel().getPosition().getRow();
        int col = getModel().getPosition().getCol();

        int terminalWidth = getSize().getColumns();
        int terminalHeight = getSize().getRows();

        int boardWidth = getModel().getPosition().getCol() * 2;
        int boardHeight = getModel().getPosition().getRow();

        int startX = (terminalWidth - boardWidth) / 2;
        int startY = (terminalHeight - boardHeight) / 2;

        graphics.putString(startX + col * 2 - 1, startY + row, "[");
        graphics.putString(startX + col * 2 + 1, startY + row, "]");
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        refresh();
    }


}
