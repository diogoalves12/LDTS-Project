package controller;

import controller.state.ControllerState;
import controller.state.FactoryState;
import model.Setup;

import javax.naming.spi.StateFactory;

public class Controller {
    private ControllerState<?> state;

    public Controller(FactoryState Factory) {
        Setup setup = new Setup(30,30, Setup.Difficulty.NORMAL);
        this.state = Factory.createState("MENU", setup);
    }

}