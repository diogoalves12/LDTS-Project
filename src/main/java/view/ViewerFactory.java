package view;

import com.googlecode.lanterna.screen.Screen;
import model.game.Board;
import view.game.BoardViewer;

public class ViewerFactory {
    private final Screen screen;

    public ViewerFactory(Screen screen) {
        this.screen = screen;
    }

    public static Viewer<Board> createBoardViewer(Board board, Screen screen) {
        return new BoardViewer(board, screen);
    }
}
