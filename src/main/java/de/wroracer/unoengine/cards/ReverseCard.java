package de.wroracer.unoengine.cards;

import de.wroracer.unoengine.Game;
import de.wroracer.unoengine.Player;

public class ReverseCard extends Card{
    public ReverseCard(CardColor color) {
        super(CardType.REVERSE, color);
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
        game.changeDirection();
        super.play(game,player);
    }

}
