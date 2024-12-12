package view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.menu.MenuModel;
import view.Viewer;

import java.io.IOException;
import java.util.List;

public class MenuViewer extends Viewer<MenuModel> {

    public MenuViewer(MenuModel menu, Screen screen){
        super(menu,screen);
    }

    @Override
    public void draw() throws IOException {
        Screen screen = getScreen();
        TextGraphics textGraphics = getTextGraphics();
        MenuModel menu = getModel();

        screen.clear();
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.putString(32,1,"Minesweeper");

        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.putString(32,5,"=Start Menu=");

        List<String> options = menu.getOptions();

        for(int i = 0; i < options.size(); i++){
            String Text = options.get(i);
            String ColorHex = menu.isSelected(i) ? "#00FF00" : "#FFFFFF";

            textGraphics.setForegroundColor(TextColor.Factory.fromString(ColorHex));
            textGraphics.putString(32,6 + i,Text);
        }

        screen.refresh();

    }
}
