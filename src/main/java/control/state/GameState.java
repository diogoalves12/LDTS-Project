package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.game.Game;
import view.View;
import view.game.BoardViewer;

import java.io.IOException;

public class GameState extends ControllerState<Game> {
    Game game;
    BoardViewer viewer;

    public GameState(Game game, BoardViewer viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.game = game;
        this.viewer = viewer;
    }

    @Override
    public View<Game> getViewer() {
        return null;
    }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        return null;
    }
}
