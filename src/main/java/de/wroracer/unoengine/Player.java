package de.wroracer.unoengine;

import de.wroracer.unoengine.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private List<Card> hand;
    private UUID id;

    public Player(){
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
