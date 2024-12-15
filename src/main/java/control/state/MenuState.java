package control.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.menu.MenuModel;
import view.View;
import view.menu.MenuView;

public class MenuState extends ControllerState<MenuModel> {
    TextGraphics graphics;
    MenuModel model;
    MenuView view;

    public MenuState(MenuModel model, MenuView view, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.view = view;
        this.graphics = view.getGraphics();
    }


    @Override
    public View<MenuModel> getViewer() { return view; }

    @Override
    public void update(Controller controller, InputKey inputkey) {

    }
}
