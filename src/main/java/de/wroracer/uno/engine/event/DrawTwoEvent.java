package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;

public class DrawTwoEvent extends UnoEvent {
    private final Player next;
    private final Player drawer;

    public DrawTwoEvent(Player next, Player drawer) {
        super("draw two");
        this.next = next;
        this.drawer = drawer;
    }

    public Player getNext() {
        return next;
    }

    public Player getDrawer() {
        return drawer;
    }
}
