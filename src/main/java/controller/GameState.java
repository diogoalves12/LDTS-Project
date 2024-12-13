package controller;

import javax.swing.*;

public interface GameState {
    void handleInput(Controller controller, KeyStroke keyStroke) throws Exception;
}
