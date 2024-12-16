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
        refresh();

    }

    private void setBackground() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#333333"));
        graphics.fill(' ');
    }

    private void drawTitle(int col, int row){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(col + 5, row++, " GGG    AAA   M   M  EEEEE     OOO  V   V EEEEE RRR  ");
        graphics.putString(col + 5, row++, "G      A   A  MM MM  E        O   O V   V E     R  R ");
        graphics.putString(col + 5, row++, "G GGG  AAAAA  M M M  EEEE     O   O V   V EEEE  RRR  ");
        graphics.putString(col + 5, row++, "G   G  A   A  M   M  E        O   O  V V  E     R  R ");
        graphics.putString(col + 5, row++, " GGG   A   A  M   M  EEEEE     OOO    V   EEEEE R   R");

    }

    private void drawContent(int col, int row){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));

        for(int i = 0; i < getModel().getTotalSections(); i++) {
            String section = getModel().getSection(i);
            graphics.putString(col + 10, row + i + 10, section);

        }

    }




}
