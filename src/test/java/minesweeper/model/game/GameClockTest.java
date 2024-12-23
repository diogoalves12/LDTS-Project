package minesweeper.model.game;

import minesweeper.model.game.GameClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameClockTest {

    private Clock mockClock;
    private GameClock gameClock;

    @BeforeEach
    public void setUp() {
        mockClock = Mockito.mock(Clock.class);
        gameClock = new GameClock(mockClock);
    }

    @Test
    public void testStartClock() {
        Instant initialTime = Instant.parse("2023-10-10T12:00:00Z");
        when(mockClock.instant()).thenReturn(initialTime);

        gameClock.startClock();

        assertEquals(initialTime, gameClock.getStart());
        assertTrue(gameClock.isRunning());
    }

    @Test
    public void testStopClock() {
        gameClock.startClock();
        gameClock.stopClock();

        assertFalse(gameClock.isRunning());
    }

    @Test
    public void testResetClock() {
        gameClock.startClock();
        gameClock.resetClock();

        assertFalse(gameClock.isRunning());
        assertNull(gameClock.getStart());
    }

    @Test
    public void testGetCurrent() {
        Instant currentTime = Instant.parse("2023-10-10T12:30:00Z");
        when(mockClock.instant()).thenReturn(currentTime);

        assertEquals(currentTime, gameClock.getCurrent());
    }

    @Test
    public void testGetElapsedSeconds() {
        Instant startTime = Instant.parse("2023-10-10T12:00:00Z");
        Instant laterTime = Instant.parse("2023-10-10T12:00:10Z");

        when(mockClock.instant()).thenReturn(startTime).thenReturn(laterTime);

        gameClock.startClock();
        int elapsedSeconds = gameClock.getElapsedSeconds();

        assertEquals(10, elapsedSeconds);
    }

    @Test
    public void testResetElapsedSeconds() {
        gameClock.resetClock();
        assertEquals(0, gameClock.getElapsedSeconds());
    }

    @Test
    public void testMultipleStarts() {
        Instant Time1 = Instant.parse("2023-10-10T12:00:00Z");
        Instant Time2 = Instant.parse("2023-10-10T12:05:00Z");

        when(mockClock.instant()).thenReturn(Time1, Time2);

        gameClock.startClock();
        gameClock.startClock();

        assertEquals(Time1, gameClock.getStart());
    }

}