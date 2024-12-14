package view.help;

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
        // yet to implement
        drawTitle();
        drawContent();
        refresh();

    }


    private void drawTitle() {

    }

    private void drawContent() {
        HelpModel model = getModel();

        for(int i = 0; i < model.getTotalSections(); i ++){
            String section = model.getSection(i);
            graphics.putString(2, i + 3, section);
        }
    }




}
