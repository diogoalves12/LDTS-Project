package minesweeper.model.game;

import minesweeper.model.Position;

import java.util.Random;

public class BoardBuilder{
    private Board board;
    private Random random;

    public BoardBuilder() {
        board = Board.getInstance();
        random = new Random();
    }

    public void buildBoard(int freq) {
        for(int x  = 0; x < board.getRows(); x++) {
            for(int y = 0; y < board.getCols(); y++) {
                populateCell(board, new Position(x, y), freq);
            }
        }
    }

    private void populateCell(Board board, Position position, int freq) {
        if(isMinePlaced(freq)) {
            Cell cell = CellFactory.createCell(true, position.getRow(), position.getCol());
            board.addCell(position, cell);
        }
    }

    private boolean isMinePlaced(int freq) {
        return random.nextGaussian() * 10 - freq > 5;
    }

}
