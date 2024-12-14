package controller.state;

import model.Setup;

public class FactoryState {

    public static ControllerState<?> createState(String stateName, Setup setup) {
        return switch (stateName) {
            case "MENU" -> new MenuState(setup);
            case "GAME" -> new GameState(setup);
            case "HELP" -> new HelpState();
            default -> throw new IllegalStateException("Unexpected value: " + stateName);
        };
    }
}
