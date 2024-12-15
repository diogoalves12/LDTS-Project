package view.game;

import model.GameSetup;

import model.game.Board;
import model.game.Cell;
import view.View;
import view.ViewFactory;

import java.io.IOException;

public class CellViewer extends View<Cell> {

    public CellViewer(Cell model) {
        super(model);
    }

    @Override
    public void draw() throws IOException {
        Cell cell = getModel();

        int row  = cell.getRow();
        int col = cell.getCol();

        String empty = " ";
        String color = "#FFFFFF";

        if(!cell.isRevealed()){
            if(cell.isFlagged()){
                empty = "F";
                color = "#FFD700";
            }else{
                empty = "#";
                color = "#CCCCCC";
            }

        } else {
            if(cell.hasMine()){
                empty = "*";
                color = "#FF0000";
            } else {
                int adjacentMines = cell instanceof model.game.NormalCell ? cell.getAdjacentMines() : 0;
                if(adjacentMines > 0){
                    empty = String.valueOf(adjacentMines);
                    color = "#00FF00";
                } else {
                    empty = " ";
                    color = "#FFFFFF";
                }
            }
        }

    }

}
