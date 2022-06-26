package de.wroracer.unoengine.cards;

import de.wroracer.unoengine.Game;
import de.wroracer.unoengine.Player;

public class SkipCard extends Card{
    public SkipCard( CardColor color) {
        super(CardType.SKIP, color);
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
        return card.getColor() == getColor();
    }

    @Override
    public void play(Game game, Player player) {
        game.nextPlayer();
        super.play(game, player);
    }
}
