package control.state;

import model.GameSetup;
import model.menu.MenuModel;
import view.menu.MenuView;

public class StateFactory {

    public MenuState getMenuState(GameSetup setup) {
        MenuModel model = new MenuModel();
        MenuView view = new MenuView(model);
        return new MenuState(model, view, setup, this);
    }

}
