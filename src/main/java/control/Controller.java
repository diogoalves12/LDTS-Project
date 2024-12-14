package control;

import control.state.ControllerState;
import control.state.StateFactory;
import model.GameSetup;
import model.game.Game;

import static model.GameSetup.Difficulty.NORMAL;

public class Controller {
    ControllerState<?> state;
    Game game = null;

    public Controller(StateFactory factory) {
        GameSetup setup = new GameSetup(20,20, NORMAL);
    }


}
