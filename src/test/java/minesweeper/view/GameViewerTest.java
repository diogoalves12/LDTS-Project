package minesweeper.view;

import minesweeper.model.game.Board;
import minesweeper.model.game.Cursor;
import minesweeper.model.game.Game;
import minesweeper.model.game.GameClock;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private BoardViewer boardViewerMock;
    private ClockViewer clockViewerMock;
    private CursorViewer cursorViewerMock;
    private GameViewer gameViewer;

    ViewFactory factory;

    @BeforeEach
    void setUp() throws IOException {

        Game gameMock = mock(Game.class);
        factory = mock(ViewFactory.class);
        boardViewerMock = mock(BoardViewer.class);
        clockViewerMock = mock(ClockViewer.class);
        cursorViewerMock = mock(CursorViewer.class);

        Board board = mock(Board.class);
        GameClock clock = mock(GameClock.class);
        Cursor cursor = mock(Cursor.class);

        when(factory.createBoardViewer(board)).thenReturn(boardViewerMock);
        when(factory.createClockView(clock)).thenReturn(clockViewerMock);
        when(factory.createCursorView(cursor)).thenReturn(cursorViewerMock);

        when(gameMock.getBoard()).thenReturn(board);
        when(gameMock.getClock()).thenReturn(clock);
        when(gameMock.getCursor()).thenReturn(cursor);

        gameViewer = new GameViewer(gameMock, factory);

        doNothing().when(boardViewerMock).draw(anyInt(),anyInt());
        doNothing().when(clockViewerMock).draw(anyInt(),anyInt());
        doNothing().when(cursorViewerMock).draw(anyInt(),anyInt());

    }

    // @Test
    void testDraw() throws IOException {

        gameViewer.draw(0,0);

        verify(clockViewerMock, times(1)).draw(anyInt(),anyInt());
        verify(boardViewerMock, times(1)).draw(anyInt(),anyInt());
        verify(cursorViewerMock, times(1)).draw(anyInt(),anyInt());

    }

}