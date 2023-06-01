package de.wroracer.unoengine.card;

import de.wroracer.unoengine.Game;

public class ReverseCard extends Card implements Special {
    public ReverseCard(Color color) {
        super(color, Type.REVERSE);
    }

    @Override
    public void performAction(Game game) {
        //TODO
    }
}
