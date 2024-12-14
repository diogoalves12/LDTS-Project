package model.menu;

import java.util.List;

public class MenuModel {

    public enum Option {PLAY, HELP, QUIT}


    private final List<Option> options = List.of(Option.PLAY, Option.HELP, Option.QUIT);
    private int selected;

    public MenuModel() {
        this.selected = 0;
    }

    public List<Option> getOptions() {
        return options;
    }

    public Option getSelectedOption() { return options.get(selected);}

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

    public void next() { selected = (selected + 1) % options.size(); }

    public void previous() { selected = (selected - 1 + options.size()) % options.size(); }
}
