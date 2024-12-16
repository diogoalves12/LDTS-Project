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
        drawTitle(col, row + 2);
        drawContent(col,row);

    }

    private void setBackground() {
        TextGraphics graphics = getGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#333333"));
        graphics.fill(' ');
    }

    private void drawTitle(int col, int row){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(col, row, "GAME OVER");

    }

    private void drawContent(int col, int row){
        TextGraphics graphics = getGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));

        for(int i = 0; i < getModel().getTotalSections(); i++) {
            String section = getModel().getSection(i);
            graphics.putString(col + 2, row + i + 2, section);

        }

    }




}
