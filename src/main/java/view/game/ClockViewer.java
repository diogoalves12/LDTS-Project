package view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.game.GameClock;
import view.View;

import java.io.IOException;
import java.time.Clock;

public class ClockViewer extends View<GameClock> {


    public ClockViewer(GameClock model) { super(model);
    }

    @Override
    public void draw() throws IOException {
        TextGraphics graphics = getGraphics();

        GameClock model = getModel();
        String time = model.getElapsedSeconds() + "s";

        TerminalSize size = getSize();

        graphics.putString(size.getColumns() / 2 - "Time:".length() / 2, 2, "Time");

        drawBorder();

        graphics.putString(size.getColumns() / 2 - time.length() / 2, size.getRows() / 2, time);

        refresh();

    }

    private void drawBorder(){
        TextGraphics graphics = getGraphics();
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
