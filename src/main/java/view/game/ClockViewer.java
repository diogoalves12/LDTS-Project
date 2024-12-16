package view.game;

import com.googlecode.lanterna.TerminalSize;
import model.game.GameClock;
import view.View;

import java.io.IOException;

public class ClockViewer extends View<GameClock> {
    private static final int RIGHT_PADDING = 5;

    public ClockViewer(GameClock model) { super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {

        GameClock model = getModel();
        String time = model.getElapsedSeconds() + "s";

        TerminalSize size = getSize();

        // drawBorder();
        int rightPadding = 10;
        graphics.putString(size.getColumns() - RIGHT_PADDING, 0, time);

        refresh();

    }

    private void drawBorder(){
        TerminalSize size = getSize();

        for(int col = 0; col < size.getColumns(); col++){
            graphics.putString(col, 1, "-");
            graphics.putString(col, size.getRows() - 2, "-");
        }

        for(int row = 0; row < size.getRows() - 2 ; row++){
            graphics.putString(0, row, "|");
            graphics.putString(size.getColumns() - 1, row, "|");
        }
    }

}
