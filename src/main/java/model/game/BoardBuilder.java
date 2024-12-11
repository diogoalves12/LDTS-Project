package model.game;

import model.Setup;
import java.util.Random;

public class BoardBuilder{
    private Board board;
    private int rows, cols;

    public BoardBuilder(Setup setup) {
        this.rows = setup.getBoardRows();
        this.cols = setup.getBoardRows();
        this.board = Board.getInstance(rows, cols);
    }

    public void placeMines (int freq) {
        Random random = new Random();

        for(int x  = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(GaussianBombInitializer(random,freq)) {
                    board.addCell(x, y, new MineCell(x,y));
                }
            }
        }

    }

    private boolean GaussianBombInitializer(Random rand, int freq) {
        return rand.nextGaussian() * 10 - freq > 5;
    }

}
