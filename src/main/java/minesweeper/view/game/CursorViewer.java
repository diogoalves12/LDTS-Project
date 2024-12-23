package minesweeper.view.game;

import com.googlecode.lanterna.TextColor;
import minesweeper.model.game.Cursor;
import minesweeper.view.View;

import java.io.IOException;

public class CursorViewer extends View<Cursor> {

    public CursorViewer(Cursor model) {
        super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2E3B44"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));

        int colX = col + getModel().getPosition().getCol() * 2 - 1 ;
        int rowY = row + getModel().getPosition().getRow();

        graphics.putString(colX, rowY, "[");
        graphics.putString(colX + 2, rowY, "]");
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        refresh();
    }


}
