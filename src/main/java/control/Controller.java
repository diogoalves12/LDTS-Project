package control;

import control.state.ControllerState;
import control.state.StateFactory;
import model.GameSetup;
import model.game.Game;

import java.io.IOException;

import static model.GameSetup.Difficulty.NORMAL;

public class Controller {
    ControllerState<?> state;
    Game game = null;

    public Controller(StateFactory factory) {
        GameSetup setup = new GameSetup(20,20, NORMAL);
        this.state = factory.getMenuState(setup);
    }

    public Game getGame() { return game; }

    public void setGame(Game game) { this.game = game; }

    public void launch() throws IOException, InterruptedException {
        while(this.state != null){
           this.state = this.state.update(this,this.state.processInput());
           Thread.sleep(35);
        }
    }
}
