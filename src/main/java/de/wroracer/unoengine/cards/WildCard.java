package de.wroracer.unoengine.cards;

import de.wroracer.unoengine.Game;
import de.wroracer.unoengine.Player;

public class WildCard extends Card {
    public WildCard() {
        super(CardType.WILD, CardColor.BLACK);
    }

    @Override
    public void setColor(CardColor color) {
        super.setColor(color);
    }

    @Override
    public boolean isPlayable(Card card) {
        return card.getColor() == getColor();
    }

    @Override
    public boolean canPlayedOn(Card card) {
        return true;
    }

    @Override
    public void play(Game game, Player player) {
        super.play(game, player);
    }

}
