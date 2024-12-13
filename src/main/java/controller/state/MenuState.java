package controller.state;

import com.googlecode.lanterna.screen.Screen;
import model.Setup;
import model.game.Game;
import model.menu.MenuModel;
import view.Viewer;
import view.menu.MenuViewer;

public class MenuState  extends ControllerState<MenuModel>{

    public MenuState(Setup setup) {
        super(setup);

    }

    @Override
    public Viewer<MenuModel> getViewer() {
        return null;    // for now
    }

}
