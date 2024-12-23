package minesweeper.model.game;

import java.util.ArrayList;

public class GameOver {
    private ArrayList<String> text;
    private boolean hasWon;


    public GameOver(){
        this.text = new ArrayList<>();
        this.hasWon = false;
    }

    public void loadContent(boolean hasWon) {
        if (hasWon) {
            text.add("You won!");
            text.add("Congratulations!");
            text.add("Press 'ESC' to return to the menu.");
        } else {
            text.add("You lost!");
            text.add("Better luck next time!");
            text.add("Press 'ESC' to return to the menu.");
        }
    }

    public ArrayList<String> text(){
        return text;
    }

    public String getSection(int index){
        if(index >= 0 && index < text.size()){
            return text.get(index);
        }else{
            throw new IllegalArgumentException("Índice inválido: " + index);
        }
    }

    public int getTotalSections(){
        return text.size();
    }

    public void setHasWon(boolean hasWon){
        this.hasWon = hasWon;
    }

    public boolean hasWon(){
        return hasWon;
    }

}

