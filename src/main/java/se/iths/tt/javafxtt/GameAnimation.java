package se.iths.tt.javafxtt;

import javafx.animation.AnimationTimer;

public abstract class GameAnimation extends AnimationTimer {

    long lastFrameTimeNanos;

    @Override
    public void handle(long now) {
        float secondsSinceLastFrame = (float)((now - lastFrameTimeNanos) / 1e9);
        lastFrameTimeNanos = now;
        tick(secondsSinceLastFrame);
    }

    public abstract void tick(float secondsSinceLastFrame);
}
