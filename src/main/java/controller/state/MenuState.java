package controller.state;

import com.googlecode.lanterna.screen.Screen;
import model.game.Game;
import view.menu.MenuViewer;

public class MenuState {
    private final MenuViewer menuViewer;

    public MenuState(Screen screen, Game game) {
        this.menuViewer = new MenuViewer(game.getMenuModel(), screen); // need to implement
                                                                      // a getMenuModel() on the game class
    }
}
