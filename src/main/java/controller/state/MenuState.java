package controller.state;

import model.Setup;
import model.menu.MenuModel;
import view.View;

public class MenuState  extends ControllerState<MenuModel>{

    public MenuState(Setup setup) {
        super(setup);

    }

    @Override
    public View<MenuModel> getViewer() {
        return null;    // for now
    }

}
