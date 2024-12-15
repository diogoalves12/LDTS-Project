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
        clear();
        graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));

        int row = getModel().getRow();
        int col = getModel().getCol();

        graphics.putString(col * 2, row, "[");
        graphics.putString(col * 2 + 2, row, "]");
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        refresh();
    }


}
