package controller.state;

import model.Setup;
import model.menu.MenuModel;
import view.View;
import view.menu.MenuView;

public class MenuState  extends ControllerState<MenuModel>{
    private final MenuModel menuModel;

    public MenuState(Setup setup) {
        super(setup);
        this.menuModel = new MenuModel();

    }

    @Override
    public View<MenuModel> getViewer() {
        return  new MenuView(menuModel);
    }

    @Override
    public ControllerState<?> changeState() {
        return switch (menuModel.getSelectedOption()) {
            case PLAY -> new GameState(setup);    // para implementar
            case HELP -> new HelpState();    // para implementar
            case QUIT -> null;
        };

    }

}
