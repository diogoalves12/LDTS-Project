package minesweeper.view.game;

import com.googlecode.lanterna.TextColor;

import minesweeper.model.game.Board;
import minesweeper.model.game.Cell;
import minesweeper.view.View;

import java.io.IOException;

public class CellViewer extends View<Cell> {

    public CellViewer(Cell model) {
        super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        Cell cell = getModel();

        String display= " ";
        String color = "#FFFFFF";
        String backGroundColor = "#2E3B44";

        if(!cell.isRevealed()){
            if(cell.isFlagged()){
                display = "F";
                color = "#FFD700";
            }else{
                display = "#";
                color = "#CCCCCC";
                backGroundColor = "#2E3B44";
            }

        } else {
            if(cell.hasMine()){
                display = "*";
                color = "#FF0000";
            } else {
                int adjacentMines = Board.getInstance().countAdjacentMines(cell.getPosition());
                if(adjacentMines > 0){
                    display = String.valueOf(adjacentMines);
                    color = "#00F7FF";
                } else {
                    display = " ";
                    color = "#FFFFFF";
                }
            }
        }

        getGraphics().setBackgroundColor(TextColor.Factory.fromString(backGroundColor));
        getGraphics().setForegroundColor(TextColor.Factory.fromString(color));
        getGraphics().putString(col, row, display);
        
    }

}
