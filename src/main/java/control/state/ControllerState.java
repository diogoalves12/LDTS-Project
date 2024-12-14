package control.state;

import model.GameSetup;

public class ControllerState<T> {
    GameSetup setup;
    StateFactory factory;

    public ControllerState(GameSetup setup, StateFactory factory) {
        this.setup = setup;
        this.factory = factory;
    }

}
