package de.wroracer.uno.engine.card;

public class WildCard extends Card {
    public WildCard() {
        super(Color.BLACK, Type.WILDE);
    }

    public void setColor(Color color) {
        if (color != Color.BLACK) {
            this.color = color;
        }
    }

    @Override
    public boolean canPlayedOn(Card card) {
        if (this.color == Color.BLACK) {
            return false;
        }
        return super.canPlayedOn(card);
    }

    @Override
    public String toString() {
        if (color == Color.BLACK) {
            return type.toString();
        } else {
            return super.toString();
        }
    }
}
