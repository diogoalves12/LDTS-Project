package model.menu;

import model.GameSetup;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuModelTest {

    @Test
    public void testInitialState() {
        MenuModel model = new MenuModel();
        assertEquals( 0, model.getSelected());
        assertEquals(GameSetup.Difficulty.NORMAL, model.getDifficulty());
        assertEquals(3, model.getOptions().size());
    }

    @Test
    public void testSelectOption(){
        MenuModel menu = new MenuModel();
        assertEquals(MenuModel.Option.PLAY, menu.getOptions().get(0));
        assertEquals(MenuModel.Option.HELP, menu.getOptions().get(1));
        assertEquals(MenuModel.Option.QUIT, menu.getOptions().get(2));
    }

    @Test
    public void testNextOption(){
        MenuModel menu = new MenuModel();
        menu.nextOption();
        assertEquals(1, menu.getSelected());
        menu.nextOption();
        assertEquals(2, menu.getSelected());
        menu.nextOption();
        assertEquals(0, menu.getSelected());
    }

    @Test
    public void testPreviousOption(){
        MenuModel menu = new MenuModel();
        menu.previousOption();
        assertEquals(2, menu.getSelected());
        menu.previousOption();
        assertEquals(1, menu.getSelected());
        menu.previousOption();
        assertEquals(0, menu.getSelected());
    }

    @Test
    public void testNextDifficulty(){
        MenuModel menu = new MenuModel();
        menu.nextDifficulty();
        assertEquals(GameSetup.Difficulty.HARD, menu.getDifficulty());
        menu.nextDifficulty();
        assertEquals(GameSetup.Difficulty.EASY, menu.getDifficulty());
        menu.nextDifficulty();
        assertEquals(GameSetup.Difficulty.NORMAL, menu.getDifficulty());
    }

    @Test
    public void testPreviousDifficulty(){
        MenuModel menu = new MenuModel();
        menu.previousDifficulty();
        assertEquals(GameSetup.Difficulty.EASY, menu.getDifficulty());
        menu.previousDifficulty();
        assertEquals(GameSetup.Difficulty.HARD, menu.getDifficulty());
        menu.previousDifficulty();
        assertEquals(GameSetup.Difficulty.NORMAL, menu.getDifficulty());
    }


}
