package de.wroracer.uno.engine.error;

import de.wroracer.uno.engine.card.Card;

public class CardNotPlayableError extends UnoError {
    public CardNotPlayableError(Card play, Card current) {
        super("The card " + play + " is not playable on " + current);
    }
}
