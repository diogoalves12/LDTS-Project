package control.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import control.Controller;
import control.InputKey;
import model.GameSetup;
import view.View;

import java.io.IOException;

public abstract class ControllerState<T> {

    StateFactory factory;
    GameSetup setup;


    public ControllerState(GameSetup setup, StateFactory factory) {
        this.setup = setup;
        this.factory = factory;
    }

    public abstract View<T> getViewer();

    protected void draw() throws IOException {
        this.getViewer().draw();
    }

    protected ControllerState<?> changeState(ControllerState<?> nextState) throws IOException {
        if(nextState != this) this.getViewer().close();
        return nextState;
    }

    public InputKey processInput() throws IOException {
        draw();
        InputKey inputKey = this.getViewer().getCommand();
        if(inputKey == null) return this.getViewer().getCommand();
        return inputKey;
    }

    public abstract ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException;
}
