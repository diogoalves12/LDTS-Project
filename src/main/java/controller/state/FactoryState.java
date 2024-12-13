package controller.state;

import model.Setup;

public class FactoryState {

    public static ControllerState<?> createState(String stateName, Setup setup) {
        return switch (stateName) {
            case "MENU" -> new MenuState(setup);
        }
    }
}
