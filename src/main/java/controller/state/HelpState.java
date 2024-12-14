package controller.state;

import com.googlecode.lanterna.input.KeyStroke;
import model.help.HelpModel;
import view.View;
import view.help.HelpPageView;

import javax.swing.*;
import java.io.IOException;

public class HelpState extends ControllerState<HelpModel> {
    private final HelpModel model;
    private final HelpPageView view;

    public HelpState() {
        super(null);
        this.model = new HelpModel();
        this.view = new HelpPageView(this.model);
    }

    @Override
    public View<HelpModel> getViewer() {
        return view;
    }

    @Override
    public ControllerState<?> changeState() {
        try {
            view.draw();
            KeyStroke key = view.getScreen().pollInput();
            if(key != null) {
                switch (key.getKeyType()) {
                    case Escape:
                        new MenuState(null);
                    default:
                }
            }
            return this;

        } catch (IOException e) {
           e.printStackTrace();
           return null;
        }
    }
}
