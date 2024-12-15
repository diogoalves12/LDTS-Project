package control.state;

import model.GameSetup;
import model.game.Game;
import model.help.HelpModel;
import model.menu.MenuModel;
import view.ViewFactory;
import view.game.BoardViewer;
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
        BoardViewer viewer = ViewFactory.createBoardViewer(game.getBoard());
        return new GameState(game, viewer, setup, this);
    }

    public HelpState getHelpState(GameSetup setup) {
        HelpModel model = new HelpModel();
        HelpPageView viewer = ViewFactory.createHelpPageView(model);
        return new HelpState(model, viewer, setup, this);
    }



}
