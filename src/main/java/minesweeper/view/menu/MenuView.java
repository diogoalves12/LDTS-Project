package minesweeper.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import minesweeper.model.menu.MenuModel;
import minesweeper.view.View;

import java.io.IOException;
import java.util.List;

public class MenuView extends View<MenuModel> {
    private static final String DEFAULT_COLOR = "#FFFFFF";   // branco
    private static final String SELECTED_COLOR = "#FF00F7";  // rosa
    private static final String TITLE_COLOR = "#00F7FF";     // ciano
    private static final String TITLE_TEXT = "minesweeper";

    public MenuView(MenuModel menu) {
        super(menu);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        TextGraphics graphics = getGraphics();
        clear();
        fillBackground();

        int totalHeight = graphics.getSize().getRows();
        int totalWidth = graphics.getSize().getColumns();
        int centerRow = totalHeight / 2;

        draw3DTitle(graphics, centerRow - 6, totalWidth);

        drawCentered(graphics, centerRow - 4, "---- Start Menu ----", DEFAULT_COLOR, totalWidth);

        drawMenu(graphics, centerRow, totalWidth);

        drawDifficulty(graphics, centerRow + 5, totalWidth);

        refresh();
    }

    private void drawCentered(TextGraphics graphics, int row, String text, String color, int totalWidth) {
        int col = (totalWidth - text.length()) / 2;
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(col, row, text);
    }

    private void drawDifficulty(TextGraphics graphics, int row, int TotalWidth) {
        String difficulty = getModel().getDifficulty().name();
        String color;
        switch(difficulty.toLowerCase()){
            case "easy" -> color = "#00FF00";
            case "normal" -> color = "#FFD700";
            case "hard" -> color = "#FF4500";
            default -> color = DEFAULT_COLOR;
        }

        String Text = "Difficulty: " + difficulty;
        drawCentered(graphics, row + 5, Text, color, TotalWidth);
    }

    private void draw3DTitle(TextGraphics graphics, int row, int totalWidth) {
        String[] asciiTitle = getModel().getAsciiTitle();
        int col = (totalWidth - TITLE_TEXT.length()) / 2;

        graphics.setForegroundColor(TextColor.Factory.fromString(TITLE_COLOR));
        for (int i = 0; i < asciiTitle.length; i++) {
            graphics.putString(col - 22, row + i - 10, asciiTitle[i]);
        }

    }

    private void drawMenu(TextGraphics graphics, int startRow, int totalWidth) {
        MenuModel menu = getModel();
        List<MenuModel.Option> options = menu.getOptions();
        int selected = menu.getSelected();

        int menuStartRow = startRow - (options.size() / 2);
        int rowSpace =  startRow - (options.size() / 2);
        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).name();
            String color = (i == selected) ? SELECTED_COLOR : DEFAULT_COLOR;

            if(i == selected){
                optionText = ">   " + optionText + "   <";
            }

            drawCentered(graphics, menuStartRow + i * 2, optionText, color, totalWidth);
        }

    }

}