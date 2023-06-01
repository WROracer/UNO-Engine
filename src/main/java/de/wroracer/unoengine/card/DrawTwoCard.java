package de.wroracer.unoengine.card;

import de.wroracer.unoengine.Game;

public class DrawTwoCard extends Card implements Special {
    public DrawTwoCard(Color color) {
        super(color, Type.DRAW_TWO);
    }

    @Override
    public void performAction(Game game) {
        //TODO
    }
}
