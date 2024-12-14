package controller.state;

import model.Setup;
import model.game.Board;
import model.game.Game;
import view.View;
import view.game.BoardViewer;

public class GameState extends ControllerState<Board> {
    private final Game game;
    private final BoardViewer viewer;

    public GameState(Setup setup) {
        super(setup);
        this.game = new Game(setup);
        this.viewer = new BoardViewer(game.getBoard());
    }

    @Override
    public View<Board> getViewer() {
        return viewer;
    }

    @Override
    public ControllerState<?> changeState() {
        return null;
    }
}
