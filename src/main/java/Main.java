import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.Setup;
import model.game.Board;
import model.game.BoardBuilder;
import model.menu.MenuModel;
import view.View;
import view.game.BoardViewer;
import view.menu.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try{
            Setup setup = new Setup(30,30, Setup.Difficulty.NORMAL);

            Board.initialize(setup.getBoardRows(), setup.getBoardCols());
            Board board = Board.getInstance();

            BoardBuilder builder = new BoardBuilder(null);
            builder.buildBoard(6);

            TerminalSize terminalSize = new TerminalSize(board.getCols() * 2 + 2, board.getRows() + 2);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            BoardViewer viewer = new BoardViewer(board, screen);

            // Screen screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
            // screen.startScreen();
            // screen.doResizeIfNecessary();
            // screen.setCursorPosition(null);

            // List<String> options = new ArrayList<>();
            // options.add("Start Game");
            // options.add("Options");
            // options.add("Exit");

            // MenuModel menu = new MenuModel(options);

            // View<MenuModel> viewer = new MenuView(menu, screen);

            while (true) {
                viewer.draw();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
