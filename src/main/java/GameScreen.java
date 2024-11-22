import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import java.io.IOException;

public class GameScreen {

    private static Screen screen;

    public GameScreen() throws IOException {
        TerminalSize terminalSize = new TerminalSize(80, 80);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // remover depois, vamos precisar do cursor
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

}
