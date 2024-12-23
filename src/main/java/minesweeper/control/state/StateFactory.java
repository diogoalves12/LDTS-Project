package minesweeper.control.state;

import minesweeper.model.GameSetup;
import minesweeper.model.game.Game;
import minesweeper.model.game.GameOver;
import minesweeper.model.help.HelpModel;
import minesweeper.model.menu.MenuModel;
import minesweeper.view.ViewFactory;
import minesweeper.view.GameOverViewer;
import minesweeper.view.GameViewer;
import minesweeper.view.help.HelpPageView;
import minesweeper.view.menu.MenuView;

public class StateFactory {

    public MenuState getMenuState(GameSetup setup) {
        MenuModel model = new MenuModel();
        MenuView view = ViewFactory.createMenuView(model);
        return new MenuState(model, view, setup, this);
    }

    public GameState getGameState(GameSetup setup) {
        Game game = new Game(setup);
        GameViewer viewer = new GameViewer(game, new ViewFactory());
        return new GameState(game, viewer, setup, this);
    }

    public HelpState getHelpState(GameSetup setup) {
        HelpModel model = new HelpModel();
        HelpPageView viewer = ViewFactory.createHelpPageView(model);
        return new HelpState(model, viewer, setup, this);
    }

    public GameOverState getGameOverState(GameSetup setup) {
        GameOver model = new GameOver();
        GameOverViewer viewer = ViewFactory.createGameOverView(model);
        return new GameOverState(model, viewer, setup, this);
    }

    public GameWinState getGameWinState(GameSetup setup) {
        GameOver model = new GameOver();
        GameOverViewer viewer = new GameOverViewer(model);
        return new GameWinState(model, viewer, setup, this);
    }


}
