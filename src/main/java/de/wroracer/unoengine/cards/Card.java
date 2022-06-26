package de.wroracer.unoengine.cards;

import de.wroracer.unoengine.Game;
import de.wroracer.unoengine.Player;

public class Card {
    private CardColor color;
    private CardType type;
    public Card(CardType type,CardColor color){
        this.type = type;
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }

    protected void setType(CardType type) {
        this.type = type;
    }

    protected void setColor(CardColor color) {
        this.color = color;
    }

    public boolean isPlayable(Card card){
        if (!card.getType().isNumber())return card.canPlayedOn(this);
        if (card.getColor() == color)return true;
        if (card.getType().getNumber()+1== type.getNumber())return true;
        return card.getType().getNumber() - 1 == type.getNumber();
    }

    public boolean canPlayedOn(Card card){
        if (card.getColor() == color)return true;
        if (card.getType().getNumber()+1== type.getNumber())return true;
        return card.getType().getNumber() - 1 == type.getNumber();
    }

    /**
     * This method is executed, when this card is played.
     * @param game the game, where the card is played.
     */
    public void play(Game game, Player player){
        game.nextPlayer();
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", type=" + type +
                '}';
    }
}
