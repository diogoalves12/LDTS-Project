package model.game;

import java.util.ArrayList;

public class GameOver {
    private ArrayList<String> text;


    public GameOver(){
        this.text = new ArrayList<>();
        loadContent();
    }

    private void loadContent(){
        text.add("You lost!");
        text.add("Better luck next time!");
        text.add("Press 'ESC' to return to the menu.");
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

}

