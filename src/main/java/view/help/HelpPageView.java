package view.help;

import com.googlecode.lanterna.TextColor;
import model.help.HelpModel;
import view.View;

import java.io.IOException;

public class HelpPageView extends View<HelpModel> {
    private static final int CONTENT_PADDING_LEFT = 2;
    private static final int CONTENT_PADDING_TOP = 1;

    public HelpPageView(HelpModel model) {
        super(model);
    }

    @Override
    public void draw(int col, int row) throws IOException {
        clear();
        drawTitle();
        drawContent();
        refresh();

    }

    private void drawTitle() {
        String[] title = getModel().getAsciiTitle();

        graphics.setForegroundColor(TextColor.Factory.fromString("#00F7FF"));

        for(int i = 0; i < title.length; i ++){
            graphics.putString(CONTENT_PADDING_LEFT, CONTENT_PADDING_TOP + i, title[i]);
        }

    }

    private void drawContent() {
        HelpModel model = getModel();

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        for(int i = 0; i < model.getTotalSections(); i ++){
            String section = model.getSection(i);
            graphics.putString(CONTENT_PADDING_LEFT, 10 + i * 2 , section);
        }
    }

}
