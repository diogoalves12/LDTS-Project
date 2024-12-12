package view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.game.Board;
import model.game.Cell;
import model.game.MineCell;
import model.game.NormalCell;
import view.Viewer;


import java.io.IOException;

public class GameViewer extends Viewer<Board>{

    public GameViewer(Board board, Screen screen) {
        super(board, screen);
    }

    @Override
    public void draw() throws IOException {
        Screen screen = getScreen();
        TextGraphics textGraphics = getTextGraphics();
        Board board = getModel();

        screen.clear();

        for(int row = 0; row < board.getRows(); row++){
            for(int col = 0; col < board.getCols(); col++){
                Cell cell = board.getCell(row,col);

                String display = " ";
                String ColorHex = "#AAAAAA";

                if(!cell.isRevealed()) {
                    display = "#";
                    ColorHex = "#FFFFFF";
                } else if (cell.hasMine()) {
                    display = "*";
                    ColorHex = "#FF0000";
                } else if (!cell.hasMine()){
                    // yet to implement the number of adjacent mines
                    display = "#";
                    ColorHex = "FFFFFF";
                }

                textGraphics.setForegroundColor(TextColor.Factory.fromString(ColorHex));
                textGraphics.putString(col * 2 + 1, row + 1, display);
            }
        }
        refreshScreen();
    }

}
