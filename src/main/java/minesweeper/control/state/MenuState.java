package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.menu.MenuModel;
import minesweeper.view.View;
import minesweeper.view.menu.MenuView;

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
            case LEFT -> model.previousDifficulty();
            case RIGHT ->  model.nextDifficulty();
            case ENTER -> {

                switch (model.getSelected()){
                    case 0 -> {

                        GameSetup newSetup = new GameSetup(model.getDifficulty());
                        nextState = factory.getGameState(newSetup);
                    }
                    case 1 -> nextState = factory.getHelpState(setup);
                    case 2 ->  nextState = null;
                }
            }
            case QUIT -> nextState = null;
        }
        return changeState(nextState);
    }



}
