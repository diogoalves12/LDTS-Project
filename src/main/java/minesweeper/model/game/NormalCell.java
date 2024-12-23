package minesweeper.model.game;

public class NormalCell extends Cell {
    private int adjacentMines;

    public NormalCell(int x, int y) {
        super(x, y);
        adjacentMines = 0;
    }

    @Override
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    @Override
    public int getAdjacentMines() {
        return adjacentMines;
    }

    @Override
    public boolean hasMine() {
        return false;
    }

}
