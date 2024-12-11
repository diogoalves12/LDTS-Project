package model.game;

import model.Setup;

public class Game {

    private Board board;
    Setup setup;

    public Game(Setup setup) {
        this.setup = setup;
        int freq;
        switch (setup.getDifficulty()){
            case EASY:
                freq = 8;
                break;
            case NORMAL:
                freq = 6;
                break;
            case HARD:
                freq = 5;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty");
        }
        this.board = new BoardBuilder(setup.getBoardRows(),setup.getBoardRows()).buildBoard(freq);
    }

    public Board getBoard() {
        return board;
    }

    public Setup getSetup() {
        return setup;
    }

    public int getRows(){
        return setup.getBoardRows();
    }

    public int getColumns(){
        return setup.getBoardRows();
    }




}

