import control.Controller;
import control.state.StateFactory;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new StateFactory());
        try {
            controller.launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}