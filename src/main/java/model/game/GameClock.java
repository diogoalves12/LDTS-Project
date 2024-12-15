package model.game;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class GameClock {
    private final Clock clock;
    private Instant start;
    private boolean running;

    public GameClock(Clock clock) {
        this.clock = clock;
        this.start = null;
        this.running = false;
    }

    public void startClock() {
        if (!running) {
            this.start = clock.instant();
            this.running = true;
        }
    }

    public void stopClock() {
        if (running) {
            this.running = false;
        }
    }

    public void resetClock() {
        this.start = null;
        this.running = false;
    }

    public Instant getCurrent() {
        return clock.instant();
    }

    public Instant getStart() {
        return start;
    }

    public int getElapsedSeconds() {
        if (start == null || !running) {
            return 0;
        }
        return (int) Duration.between(start, getCurrent()).toSeconds();
    }

    public boolean isRunning() {
        return running;
    }
}