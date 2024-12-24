package minesweeper.control.state;

import minesweeper.control.Controller;
import minesweeper.control.InputKey;
import minesweeper.model.GameSetup;
import minesweeper.model.Position;
import minesweeper.model.game.Game;
import minesweeper.view.View;
import minesweeper.view.GameViewer;

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
                        nextState = factory.getGameOverState(setup);
                    } else {
                        if(game.getCell(pos) != null) game.getBoard().revealEmptyArea(pos);

                        if(game.hasWon()) {
                            nextState = factory.getGameWinState(setup);
                        }

                    }

                }
            }
            case ESCAPE -> nextState = factory.getMenuState(setup);
            case FLAG -> {
                Position pos = game.getCursor().getPosition();
                game.getCell(pos).toggleFlagged();

            }
            case QUIT -> nextState = null;

            default -> {}
        }


        return changeState(nextState);
    }
}
