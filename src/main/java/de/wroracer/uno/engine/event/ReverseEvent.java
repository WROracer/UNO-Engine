package de.wroracer.uno.engine.event;

public class ReverseEvent extends UnoEvent {

    private final boolean clockwise;

    public ReverseEvent(boolean clockwise) {
        super("reverse");
        this.clockwise = clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }
}
