package controller.state;

import model.Setup;
import model.game.Game;
import view.View;

public class GameState extends ControllerState<Game> {
    private final Game game;

    public GameState(Setup setup) {
        super(setup);
        this.game = new Game(setup);
    }

    @Override
    public View<Game> getViewer() {
        return null;
    }

    @Override
    public ControllerState<?> changeState() {
        return null;
    }
}
