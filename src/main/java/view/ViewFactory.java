package view;

import com.googlecode.lanterna.screen.Screen;
import model.game.Board;
import view.game.BoardViewer;

public class ViewFactory {
    private final Screen screen;

    public ViewFactory(Screen screen) {
        this.screen = screen;
    }

    public static View<Board> createBoardViewer(Board board, Screen screen) {
        return new BoardViewer(board, screen);
    }
}
