package control.state;

import model.GameSetup;
import model.game.Game;
import model.help.HelpModel;
import model.menu.MenuModel;
import view.ViewFactory;
import view.game.BoardViewer;
import view.game.GameViewer;
import view.help.HelpPageView;
import view.menu.MenuView;

public class StateFactory {

    public MenuState getMenuState(GameSetup setup) {
        MenuModel model = new MenuModel();
        MenuView view = ViewFactory.createMenuView(model);
        return new MenuState(model, view, setup, this);
    }

    public GameState getGameState(GameSetup setup) {
        Game game = new Game(setup);
        GameViewer viewer = ViewFactory.createGameView(game);
        return new GameState(game, viewer, setup, this);
    }

    public HelpState getHelpState(GameSetup setup) {
        HelpModel model = new HelpModel();
        HelpPageView viewer = ViewFactory.createHelpPageView(model);
        return new HelpState(model, viewer, setup, this);
    }



}
