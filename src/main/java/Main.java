import view.GameScreen;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            GameScreen gameScreen = new GameScreen();
            gameScreen.run();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }
}
