package control.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.menu.MenuModel;
import view.View;
import view.menu.MenuView;

import java.io.IOException;

public class MenuState extends ControllerState<MenuModel> {
    MenuModel model;
    MenuView view;

    public MenuState(MenuModel model, MenuView viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.view = viewer;
    }


    @Override
    public View<MenuModel> getViewer() { return view; }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        ControllerState<?> nextState = this;

        switch (inputkey.getInput()) {
            case UP -> model.previousOption();
            case DOWN -> model.nextOption();
            case ENTER -> {
                switch (model.getSelected()){
                    case 0 -> nextState = factory.getGameState(setup);
                    case 1 -> nextState = factory.getHelpState(setup);
                    case 2 ->  nextState = null;
                }
            }
            case QUIT -> nextState = null;
        }
        return changeState(nextState);
    }

}
