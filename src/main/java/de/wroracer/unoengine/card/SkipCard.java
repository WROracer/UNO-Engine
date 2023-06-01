package de.wroracer.unoengine.card;

import de.wroracer.unoengine.Game;

public class SkipCard extends Card implements Special {
    public SkipCard(Color color) {
        super(color, Type.SKIP);
    }

    @Override
    public void performAction(Game game) {
        //TODO
    }
}
