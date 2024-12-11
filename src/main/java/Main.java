import view.game.GameViewer;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            GameViewer gameScreen = new GameViewer();
            gameScreen.run();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }
}
