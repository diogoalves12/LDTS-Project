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
    public void draw(int col, int row) throws IOException {

        graphics.setForegroundColor(TextColor.Factory.fromString("#F000FF"));

        int colX = col + getModel().getPosition().getCol() * 2 - 1 ;
        int rowY = row + getModel().getPosition().getRow();

        graphics.putString(colX, rowY, "[");
        graphics.putString(colX + 2, rowY, "]");
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));

        refresh();
    }


}
