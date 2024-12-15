package view;

import model.game.Board;
import model.help.HelpModel;
import model.menu.MenuModel;
import view.game.BoardViewer;
import view.help.HelpPageView;
import view.menu.MenuView;

public class ViewFactory {

    public static BoardViewer createBoardViewer(Board board) {
        return new BoardViewer(board);
    }

    public static MenuView createMenuView(MenuModel model) {
        return new MenuView(model);
    }

    public static HelpPageView createHelpPageView(HelpModel model)  {
        return new HelpPageView(model);
    }

}
