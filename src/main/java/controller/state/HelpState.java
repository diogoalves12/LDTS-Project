package controller.state;

import model.help.HelpModel;
import view.View;
import view.help.HelpPageView;

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
        return null;
    }

    @Override
    public ControllerState<?> changeState() {
        return null;
    }
}
