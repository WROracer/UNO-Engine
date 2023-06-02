package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;

public class SkipEvent extends UnoEvent {
    private final Player next;

    public SkipEvent(Player next) {
        super("skip");
        this.next = next;
    }

    public Player getNext() {
        return next;
    }
}
