package de.wroracer.uno.engine;

import de.wroracer.uno.engine.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private final List<Card> hand;
    private final UUID id;

    public Player() {
        id = UUID.randomUUID();
        hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public UUID getId() {
        return id;
    }
}
