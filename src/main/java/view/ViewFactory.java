package view;

import model.game.*;
import model.help.HelpModel;
import model.menu.MenuModel;
import view.game.*;
import view.help.HelpPageView;
import view.menu.MenuView;

public class ViewFactory {

    public BoardViewer createBoardViewer(Board board) { return new BoardViewer(board); }

    public CursorViewer createCursorView(Cursor cursor) { return new CursorViewer(cursor); }

    public ClockViewer createClockView(GameClock model) { return new ClockViewer(model); }

    public static CellViewer createCellView(Cell cell) { return new CellViewer(cell); }

    public static MenuView createMenuView(MenuModel model) { return new MenuView(model); }

    public static HelpPageView createHelpPageView(HelpModel model)  { return new HelpPageView(model); }

    public static GameOverViewer createGameOverView(GameOver gameOver) { return new GameOverViewer(gameOver); }
}
