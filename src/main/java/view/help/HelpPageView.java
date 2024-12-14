package view.help;

import com.googlecode.lanterna.TextColor;
import model.help.HelpModel;
import view.View;

import java.io.IOException;

public class HelpPageView extends View<HelpModel> {
    private static final String DEFAULT_TITLE = "HELP";

    public HelpPageView(HelpModel model) {
        super(model);
    }

    @Override
    public void draw() throws IOException {
        clear();
        drawTitle();
        drawContent();
        refresh();

    }


    private void drawTitle() {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        int center = (WIDTH - DEFAULT_TITLE.length()) / 2;
        graphics.putString(center, 1, DEFAULT_TITLE);

    }

    private void drawContent() {
        HelpModel model = getModel();

        for(int i = 0; i < model.getTotalSections(); i ++){
            String section = model.getSection(i);
            graphics.putString(2, i + 3, section);
        }
    }




}
