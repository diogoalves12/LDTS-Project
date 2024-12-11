package model;

public class MineCell extends Cell {

    public MineCell(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean hasMine(){
        return true;
    }

}
