package de.wroracer.unoengine.exeptions;

import de.wroracer.unoengine.Player;
import de.wroracer.unoengine.cards.Card;

public class PlayerHasNoCardException extends UnoException{

    public PlayerHasNoCardException(Player player, Card card) {
        super("The Player "+player+" has´nt got the Card "+card);
    }
}
