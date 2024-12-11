package view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.io.IOException;

public class GameViewer {

    private static Screen screen;
    private Board board;

    public GameViewer() throws IOException {
        this.board = new Board(30,30,10);
        TerminalSize terminalSize = new TerminalSize(board.getCols()* 2 + 2, board.getRows() + 2);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // remover depois, vamos precisar do cursor
        screen.startScreen();
        screen.doResizeIfNecessary();

    }

    protected void drawScreen() throws IOException {
        screen.clear();

        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));


        for(int row = 0; row < board.getRows(); row++) {
            for(int col = 0; col < board.getCols(); col++) {
                Cell cell = board.getCell(row, col);
                String show;
                if(cell.hasMine()){
                    textGraphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
                    show = "*";
                } else {
                    textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
                    show = "#";
                }
                textGraphics.putString(col * 2 + 1, row + 1 , show);
            }
        }
        screen.refresh();
    }

    private void processKey(){
        // To do
    }

    public void run() throws IOException {
        while(true) {
            drawScreen();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
