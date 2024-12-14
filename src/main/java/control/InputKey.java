package control;

public class InputKey {
    public enum  INPUT {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        ENTER,
        ESCAPE,
        FLAG,
        NONE,
    }

    INPUT input;
    Character key;

    public InputKey() {
        this.input = INPUT.NONE;
        this.key = ' ';
    }



}
