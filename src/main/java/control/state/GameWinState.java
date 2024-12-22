package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.game.GameOver;
import view.View;
import view.game.GameOverViewer;

import java.io.IOException;

public class GameWinState extends ControllerState<GameOver>{
    GameOver model;
    GameOverViewer viewer;

    public GameWinState(GameOver model, GameOverViewer viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.viewer = viewer;

        model.loadContent(true);
        model.setHasWon(true);
    }

    @Override
    public View<GameOver> getViewer() {
        return viewer;
    }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        ControllerState<?> nextState = this;

        switch (inputkey.getInput()) {
            case ESCAPE -> {
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
