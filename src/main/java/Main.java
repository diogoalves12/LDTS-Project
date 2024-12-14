import com.googlecode.lanterna.input.KeyStroke;
import model.menu.MenuModel;
import view.menu.MenuView;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Create the MenuModel
            MenuModel menuModel = new MenuModel();

            // Initialize MenuView with setup screen
            View<MenuModel> menuView = new MenuView(menuModel);
            menuView.setupScreen();

            // Retrieve the screen for user interaction
            menuView.getScreen().startScreen();

            // Input handling and drawing loop
            boolean running = true;
            while (running) {
                // Draw the menu
                menuView.draw();

                // Poll for user input
                KeyStroke keyStroke = menuView.getScreen().pollInput();

                if (keyStroke != null) {
                    switch (keyStroke.getKeyType()) {
                        case ArrowUp -> menuModel.previous(); // Navigate up in the menu
                        case ArrowDown -> menuModel.next(); // Navigate down in the menu
                        case Enter -> {
                            // Handle selection (e.g., show which option is selected)
                            MenuModel.Option selectedOption = menuModel.getSelectedOption();
                            System.out.println("Selected: " + selectedOption);
                            if (selectedOption == MenuModel.Option.QUIT) {
                                running = false; // Exit if Quit is selected
                            }
                        }
                        case Escape -> running = false; // Press Escape to exit
                    }
                }

                // Avoid high CPU usage
                Thread.sleep(50);
            }

            // Close the screen when exiting
            menuView.getScreen().close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}