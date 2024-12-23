package minesweeper.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import minesweeper.model.game.GameClock;
import minesweeper.view.View;

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

        graphics.setBackgroundColor(TextColor.Factory.fromString("#2E3B44"));
        graphics.putString(size.getColumns() - RIGHT_PADDING, 0, time);

        refresh();
    }

}
