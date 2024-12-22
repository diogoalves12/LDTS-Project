package view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.game.Game;
import model.game.GameOver;
import view.View;

import java.io.IOException;

public class GameOverViewer extends View<GameOver> {


    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear();
        setBackground();
        drawTitle(col, row);
        drawContent(col,row + 7);
        refresh();

    }

    private void setBackground() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#333333"));
        graphics.fill(' ');
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
