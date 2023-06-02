package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;
import de.wroracer.uno.engine.card.Card;

public class WildeDrawFourEvent extends UnoEvent {

    private final Card.Color color;
    private final Player drawer;
    private final Player next;

    public WildeDrawFourEvent(Player next, Player drawer, Card.Color color) {
        super("wilde draw four");
        this.next = next;
        this.drawer = drawer;
        this.color = color;
    }

    public Player getNext() {
        return next;
    }

    public Player getDrawer() {
        return drawer;
    }

    public Card.Color getColor() {
        return color;
    }

}
