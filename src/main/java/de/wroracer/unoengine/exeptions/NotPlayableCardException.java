package de.wroracer.unoengine.exeptions;

import de.wroracer.unoengine.cards.Card;

public class NotPlayableCardException extends UnoException{

    public NotPlayableCardException(Card played,Card card) {
        super("The Card "+played+" can not be Played on "+card);
    }
}
