package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;
import de.wroracer.uno.engine.card.Card;

public class WildeEvent extends UnoEvent {
    private final Player next;
    private final Card.Color color;

    public WildeEvent(Player next, Card.Color color) {
        super("Wild");
        this.next = next;
        this.color = color;
    }

    public Player getNext() {
        return next;
    }

    public Card.Color getColor() {
        return color;
    }
}
