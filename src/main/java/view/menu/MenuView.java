package view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.menu.MenuModel;
import view.View;

import java.io.IOException;
import java.util.List;

public class MenuView extends View<MenuModel> {
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final String SELECTED_COLOR = "#00FF00";

    public MenuView(MenuModel menu) {
        super(menu);
    }

    @Override
    public void draw() throws IOException {
        TextGraphics graphics = getGraphics();
        clear();

        int totalHeight = graphics.getSize().getRows();
        int totalWidth = graphics.getSize().getColumns();
        int centerRow = totalHeight / 2;

        drawCentered(new DrawContext(graphics, centerRow - 4, "Minesweeper", DEFAULT_COLOR, totalWidth));
        drawCentered(new DrawContext(graphics, centerRow - 2, "= Start Menu =", DEFAULT_COLOR, totalWidth));
        drawMenu(graphics, centerRow, totalWidth);

        refresh();
    }

    private void drawCentered(DrawContext context) {
        int col = calculateCenteredCol(context);
        context.graphics.setForegroundColor(TextColor.Factory.fromString(context.color));
        context.graphics.putString(col, context.row, context.text);
    }

    private int calculateCenteredCol(DrawContext context) {
        return (context.totalWidth - context.text.length()) / 2;
    }

    private void drawMenu(TextGraphics graphics, int startRow, int totalWidth) {
        MenuModel menu = getModel();
        List<MenuModel.Option> options = menu.getOptions();
        int selected = menu.getSelected();

        int menuStartRow = startRow - (options.size() / 2); // Center the menu options vertically.
        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).name();
            String color = (i == selected) ? SELECTED_COLOR : DEFAULT_COLOR;
            drawCentered(new DrawContext(graphics, menuStartRow + i, optionText, color, totalWidth));
        }
    }

    private static class DrawContext {
        final TextGraphics graphics;
        final int row;
        final String text;
        final String color;
        final int totalWidth;

        DrawContext(TextGraphics graphics, int row, String text, String color, int totalWidth) {
            this.graphics = graphics;
            this.row = row;
            this.text = text;
            this.color = color;
            this.totalWidth = totalWidth;
        }
    }
}