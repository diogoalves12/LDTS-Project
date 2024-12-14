package model.game;

import model.Position;

import java.util.Random;

public class BoardBuilder{
    private final Random random;

    public BoardBuilder(Random random) {
        this.random = (random == null) ? new Random() : random;
    }

    public void buildBoard(int freq) {
        Board board = Board.getInstance();

        int rows = board.getRows();
        int cols = board.getCols();

        for(int x  = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(randomMinesPlacement(freq)) {
                    Position position = new Position(x, y);
                    board.addCell(position, CellFactory.createCell(true, x, y));
                }
            }
        }
    }

    private boolean randomMinesPlacement(int freq) {
        return random.nextGaussian() * 10 - freq > 5;
    }

}
