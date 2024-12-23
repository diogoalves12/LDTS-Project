package minesweeper;

import minesweeper.control.Controller;
import minesweeper.control.state.StateFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller = new Controller(new StateFactory());
            controller.launch();

    }
}