package view;

import model.game.Board;
import model.game.Cursor;
import model.game.GameClock;
import model.help.HelpModel;
import model.menu.MenuModel;
import view.game.BoardViewer;
import view.game.ClockViewer;
import view.game.CursorViewer;
import view.help.HelpPageView;
import view.menu.MenuView;

import java.time.Clock;

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

    public static CursorViewer createCursorView(Cursor cursor) {
        return new CursorViewer(cursor);
    }

    public static ClockViewer createClockView(GameClock model) {
        return new ClockViewer(model);
    }

}
