package de.wroracer.unoengine.cards;

import de.wroracer.unoengine.Game;
import de.wroracer.unoengine.Player;

public class DrawTwoCard extends Card{
    private final static int cardsToDraw = 2;
    private int currentDrawCards = 0;
    public DrawTwoCard(CardColor color) {
        super(CardType.DRAW_TWO, color);
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
        if (game.getCurrentCard() instanceof DrawTwoCard){
            this.currentDrawCards = ((DrawTwoCard) game.getCurrentCard()).getCurrentDrawCards();
            this.currentDrawCards += cardsToDraw;
        }else if (game.getCurrentCard() instanceof WildDrawFourCard){
            this.currentDrawCards = ((WildDrawFourCard) game.getCurrentCard()).getCurrentDrawCards();
            this.currentDrawCards += cardsToDraw;
        }else {
            game.nextPlayer();
            for (int i = 0; i < currentDrawCards; i++) {
                game.drawCard(game.getCurrentPlayer());
            }
        }
        super.play(game, player);
    }

    public int getCurrentDrawCards() {
        return currentDrawCards;
    }

    @Override
    public String toString() {
        return "DrawTwoCard{" +
                "currentDrawCards=" + currentDrawCards +
                "} " + super.toString();
    }
}
