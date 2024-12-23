package minesweeper.control;

import minesweeper.control.state.ControllerState;
import minesweeper.control.state.StateFactory;
import minesweeper.model.GameSetup;
import minesweeper.model.game.Game;

import java.io.IOException;

import static minesweeper.model.GameSetup.Difficulty.NORMAL;

public class Controller {
    ControllerState<?> state;
    Game game = null;

    public Controller(StateFactory factory) {
        GameSetup setup = new GameSetup(14,14, NORMAL);
        this.state = factory.getMenuState(setup);
    }

    public Game getGame() { return game; }

    public void setGame(Game game) { this.game = game; }

    public void launch() throws IOException, InterruptedException {
        while(this.state != null){
           this.state = this.state.update(this,this.state.processInput());
           Thread.sleep(20);
        }
    }
}
