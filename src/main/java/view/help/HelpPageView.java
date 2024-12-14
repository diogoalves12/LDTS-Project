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

}
