package model.menu;

import model.GameSetup;

import java.util.List;

public class MenuModel {
    public enum Option {PLAY, HELP, QUIT}

    private final List<Option> options = List.of(Option.PLAY, Option.HELP, Option.QUIT);
    private int selected;
    private GameSetup.Difficulty difficulty;

    public MenuModel() {
        this.selected = 0;
        this.difficulty = GameSetup.Difficulty.NORMAL;

    }

    public List<Option> getOptions() {
        return options;
    }

    public int getSelected() {
        return selected;
    }

    public void select(int index) {
        if(index >= 0 && index < options.size()) {
            selected = index;
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    public void nextOption() { selected = (selected + 1) % options.size(); }

    public void previousOption() { selected = (selected - 1 + options.size()) % options.size(); }

    public void nextDifficulty(){
        switch(difficulty){
            case EASY -> difficulty = GameSetup.Difficulty.NORMAL;
            case NORMAL -> difficulty = GameSetup.Difficulty.HARD;
            case HARD -> difficulty = GameSetup.Difficulty.EASY;
        }
    }

    public void previousDifficulty(){
        switch(difficulty){
            case EASY -> difficulty = GameSetup.Difficulty.HARD;
            case NORMAL -> difficulty = GameSetup.Difficulty.EASY;
            case HARD -> difficulty = GameSetup.Difficulty.NORMAL;
        }
    }

    public GameSetup.Difficulty getDifficulty(){
        return difficulty;
    }
}
