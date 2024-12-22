package model.menu;

import model.GameSetup;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuModelTest {

    @Test
    public void testInitialState() {
        MenuModel model = new MenuModel();
        assertEquals( 0, model.getSelected());
        assertEquals(GameSetup.Difficulty.NORMAL, model.getDifficulty());
        assertEquals(3, model.getOptions().size());
    }

    @Test
    public void testGetOptions() {
        MenuModel menu = new MenuModel();
        assertEquals(List.of(MenuModel.Option.PLAY, MenuModel.Option.HELP, MenuModel.Option.QUIT), menu.getOptions());
    }

    @Test
    public void testSelectOption(){
        MenuModel menu = new MenuModel();
        assertEquals(MenuModel.Option.PLAY, menu.getOptions().get(0));
        assertEquals(MenuModel.Option.HELP, menu.getOptions().get(1));
        assertEquals(MenuModel.Option.QUIT, menu.getOptions().get(2));
    }

    @Test
    public void testValidSelection() {
        MenuModel menu = new MenuModel();

        menu.select(0);
        assertEquals(0, menu.getSelected());

        menu.select(1);
        assertEquals(1, menu.getSelected());

        menu.select(2);
        assertEquals(2, menu.getSelected());
    }

    @Test
    public void testInvalidSelection() {
        MenuModel menu = new MenuModel();

        assertThrows(IllegalArgumentException.class, () -> menu.select(-1));
        assertThrows(IllegalArgumentException.class, () -> menu.select(3));
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
