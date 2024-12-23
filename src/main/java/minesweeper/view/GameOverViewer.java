package minesweeper.view;

import com.googlecode.lanterna.TextColor;
import minesweeper.model.game.GameOver;
import minesweeper.view.View;

import java.io.IOException;

public class GameOverViewer extends View<GameOver> {


    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear();
        fillBackground();
        drawTitle(col, row);
        drawContent(col,row + 7);
        refresh();

    }

    private void drawTitle(int col, int row){
        graphics.setForegroundColor(getModel().hasWon() ?
                TextColor.Factory.fromString("#00FF00") :
                TextColor.Factory.fromString("#FF0000"));

        graphics.putString(col + 20, row + 10, getModel().hasWon() ? "YOU WIN!" : "GAME OVER!");

    }

    private void drawContent(int col, int row){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));

        for(int i = 0; i < getModel().getTotalSections(); i++) {
            String section = getModel().getSection(i);
            graphics.putString(col + 10, row + i + 10, section);

        }

    }

}
