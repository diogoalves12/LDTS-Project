package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.game.Board;
import model.game.GameOver;
import view.View;
import view.game.GameOverViewer;

import java.io.IOException;

public class GameOverState extends ControllerState<GameOver> {
    GameOver model;
    GameOverViewer viewer;

    public GameOverState(GameOver model, GameOverViewer viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.viewer = viewer;

        model.loadContent(false);
        model.setHasWon(false);
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
                Board.getInstance().reset();
                nextState = factory.getMenuState(setup);

            }
            default -> {}
        }
        return changeState(nextState);
    }
}
