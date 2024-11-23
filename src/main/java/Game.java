import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Game {
    private Board board;
    private GameScreen gameScreen;
    private boolean gameOver;

    public Game(int rows, int cols, int numMines) throws IOException {
        this.board = new Board(rows, cols, numMines);
        this.gameScreen = new GameScreen();
        this.gameOver = false;
    }

}
