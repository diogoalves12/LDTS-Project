package controller.state;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.Setup;
import view.View;

import java.io.IOException;

public abstract class ControllerState<T> {
    Setup setup;
    TextGraphics textGraphics;

    public ControllerState(Setup setup){
        this.setup = setup;
    }

    public void changeState(ControllerState<T> nextState){

    }

    public void draw(TextGraphics textGraphics) throws IOException {
        this.getViewer().draw();
    }

    public abstract View<T> getViewer();




}
