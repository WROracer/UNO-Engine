package de.wroracer.uno.engine.event;

public interface UnoEventListender<T extends UnoEvent> {

    void on(T event);
}
