package de.wroracer.uno.engine.event;

public abstract class UnoEvent {
    private final String name;

    public UnoEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
