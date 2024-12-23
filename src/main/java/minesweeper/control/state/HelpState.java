package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.help.HelpModel;
import minesweeper.view.View;
import minesweeper.view.help.HelpPageView;

import java.io.IOException;

public class HelpState extends ControllerState<HelpModel> {
    HelpModel model;
    HelpPageView viewer;

    public HelpState(HelpModel model, HelpPageView viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.viewer = viewer;
    }

    @Override
    public View<HelpModel> getViewer() {
        return viewer;
    }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        ControllerState<?> nextState = this;

        switch (inputkey.getInput()) {
            case ESCAPE, LEFT -> {
                nextState = factory.getMenuState(setup);
            }
            case QUIT -> {
                nextState = null;
            }
            default -> {}

        }
        return changeState(nextState);
    }

}
