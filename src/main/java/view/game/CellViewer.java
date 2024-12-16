package view.game;

import com.googlecode.lanterna.TextColor;

import model.game.Board;
import model.game.Cell;
import view.View;

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

        if(!cell.isRevealed()){
            if(cell.isFlagged()){
                display = "F";
                color = "#FFD700";
            }else{
                display = "#";
                color = "#CCCCCC";
            }

        } else {
            if(cell.hasMine()){
                display = "*";
                color = "#FF0000";
            } else {
                int adjacentMines = Board.getInstance().countAdjacentMines(cell.getPosition());
                if(adjacentMines > 0){
                    display = String.valueOf(adjacentMines);
                    color = "#00FF00";
                } else {
                    display = " ";
                    color = "#FFFFFF";
                }
            }
        }

        getGraphics().setForegroundColor(TextColor.Factory.fromString(color));
        getGraphics().putString(col, row, display);
        
    }

}
