package view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.Position;
import model.game.Board;
import model.game.Cell;
import view.View;

import java.io.IOException;

public class BoardViewer extends View<Board> {

    public BoardViewer(Board board) {
        super(board);
    }

    @Override
    public void draw() throws IOException {
        Screen screen = getScreen();
        TextGraphics textGraphics = getGraphics();
        Board board = getModel();

        screen.clear();

        for(int row = 0; row < board.getRows(); row++){
            for(int col = 0; col < board.getCols(); col++){
                Position position = new Position(row,col);
                Cell cell = board.getCell(position);

                String display = " ";
                String ColorHex = "#AAAAAA";

                if(!cell.isRevealed()) {
                    display = "#";
                    ColorHex = "#FFFFFF";
                } else if (cell.hasMine()) {
                    display = "*";
                    ColorHex = "#FF0000";
                } else if (!cell.hasMine()){
                    int adjacentMines = board.countAdjacentMines(position);
                    if(adjacentMines > 0) {
                        display = String.valueOf(adjacentMines);
                        ColorHex = "#00FF00";
                    } else {
                        display = " ";
                        ColorHex = "#FFFFFF";
                    }
                }

                textGraphics.setForegroundColor(TextColor.Factory.fromString(ColorHex));
                textGraphics.putString(col * 2 + 1, row + 1, display);
            }
        }
        refresh();
    }

}
