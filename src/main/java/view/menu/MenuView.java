package view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.menu.MenuModel;
import view.View;

import java.io.IOException;
import java.util.List;

public class MenuView extends View<MenuModel> {

    public MenuView(MenuModel menu){
        super(menu);
    }

    @Override
    public void draw() throws IOException {
        TextGraphics graphics = getGraphics();

        clear();

        drawCentered(graphics, 32, "Minesweeper", "#FFFFFF");

        drawCentered(graphics,32, "= Start Menu = ", "#FFFFFF");

        drawMenu(graphics);

        refresh();

    }

    private void drawCentered(TextGraphics graphics, int row, String text, String colorHex) {
        int col = (graphics.getSize().getColumns() - text.length()) / 2;

        graphics.setForegroundColor(TextColor.Factory.fromString(colorHex));
        graphics.putString(col, row, text);
    }

    private void drawMenu(TextGraphics graphics){
        MenuModel menu = getModel();

        List<String> options = menu.getOptions();
        int selected = menu.getSelected();

        for(int i = 0; i < options.size(); i++){
            String color = (i == selected) ? "#00FF00" : "#FFFFFF";

            drawCentered(graphics, 34 + i, options.get(i), color);

        }
    }
}
