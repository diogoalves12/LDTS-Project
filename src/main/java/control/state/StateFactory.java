package control.state;

import model.GameSetup;
import model.game.Game;
import model.menu.MenuModel;
import view.ViewFactory;
import view.game.BoardViewer;
import view.menu.MenuView;

public class StateFactory {

    public MenuState getMenuState(GameSetup setup) {
        MenuModel model = new MenuModel();
        MenuView view = ViewFactory.createMenuView(model);
        return new MenuState(model, view, setup, this);
    }

    public GameState getGameState(GameSetup setup) {
        Game game = new Game(setup);
        BoardViewer viewer = ViewFactory.createBoardViewer(game.getBoard());
        return new GameState(game, viewer, setup, this);
    }



}
