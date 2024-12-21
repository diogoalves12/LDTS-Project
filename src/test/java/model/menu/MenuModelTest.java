package model.menu;

import model.GameSetup;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuModelTest {

    @Test
    public void testMenuModel() {
        MenuModel model = new MenuModel();
        assertEquals( 0, model.getSelected());
        assertEquals(GameSetup.Difficulty.NORMAL, model.getDifficulty());
        assertEquals(3, model.getOptions().size());
    }
}
