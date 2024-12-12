import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.game.GameViewer;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

public class GameScreenTest {
    private Screen mockScreen;
    private Board mockBoard;
    private TextGraphics mockTextGraphics;
    private GameViewer gameScreen;

    @BeforeEach
    public void setUp() throws Exception {
        mockScreen = Mockito.mock(Screen.class);
        mockBoard = Mockito.mock(Board.class);
        mockTextGraphics = Mockito.mock(TextGraphics.class);

        when(mockBoard.getRows()).thenReturn(2);
        when(mockBoard.getCols()).thenReturn(2);

        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        gameScreen = new GameViewer();

        setPrivateField(gameScreen, "board", mockBoard);
        setPrivateField(gameScreen, "screen", mockScreen);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException{
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testDrawScreen() throws Exception {
        Cell mockCell = mock(Cell.class);
        when(mockCell.hasMine()).thenReturn(false);
        when(mockBoard.getCell(0,0)).thenReturn(mockCell);
        when(mockBoard.getCell(0,1)).thenReturn(mockCell);
        when(mockBoard.getCell(1,1)).thenReturn(mockCell);
        when(mockBoard.getCell(1,0)).thenReturn(mockCell);

        gameScreen.drawScreen();

        verify(mockTextGraphics, times(4)).putString(anyInt(),anyInt(), eq("#"));
    }

}
