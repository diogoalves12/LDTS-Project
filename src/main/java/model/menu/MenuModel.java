package model.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuModel {
    private final List<String> options;
    private int selected;

    public MenuModel(List<String> options) {
        this.options =  new ArrayList<>();
        this.options.add("Play");
        this.options.add("Help");
        this.options.add("Quit");
        this.selected = 0;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isSelected(int index) {
        return index == selected;
    }

    public void select(int index) {
        if(index >= 0 && index < options.size()) {
            selected = index;
        }
    }

    public int getSelected() {
        return selected;
    }
}
