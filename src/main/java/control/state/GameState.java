package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.Position;
import model.game.Board;
import model.game.Game;
import view.View;
import view.game.BoardViewer;
import view.game.GameViewer;

import java.io.IOException;

public class GameState extends ControllerState<Game> {
    Game game;
    GameViewer viewer;

    public GameState(Game game, GameViewer viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.game = game;
        this.viewer = viewer;
    }

    @Override
    public View<Game> getViewer() {
        return viewer;
    }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        ControllerState<?> nextState = this;

        switch (inputkey.getInput()) {
            case UP -> game.getCursor().moveUp();
            case DOWN -> game.getCursor().moveDown();
            case LEFT -> game.getCursor().moveLeft();
            case RIGHT -> game.getCursor().moveRight();
            case ENTER -> {

                Position pos = game.getCursor().getPosition();
                boolean reveal = game.getCell(pos).isRevealed();

                if(reveal) {
                    System.out.println("Célula já revelada!");
                } else {

                    boolean hasMine = game.getCell(pos).hasMine();

                    if(hasMine) {
                        nextState = factory.getMenuState(setup);
                    } else {
                        game.getBoard().revealEmptyArea(pos);
                    }

                }
            }
            default -> {}
        }


        return changeState(nextState);
    }
}
