package control.state;

import control.Controller;
import control.InputKey;
import model.GameSetup;
import model.help.HelpModel;
import view.View;
import view.help.HelpPageView;

import java.io.IOException;

public class HelpState extends ControllerState<HelpModel> {
    HelpModel model;
    HelpPageView viewer;

    public HelpState(HelpModel model, HelpPageView viewer, GameSetup setup, StateFactory factory) {
        super(setup, factory);
        this.model = model;
        this.viewer = viewer;
    }

    @Override
    public View<HelpModel> getViewer() {
        return null;
    }

    @Override
    public ControllerState<?> update(Controller controller, InputKey inputkey) throws IOException {
        return null;
    }
}
