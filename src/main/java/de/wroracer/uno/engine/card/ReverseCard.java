package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;
import de.wroracer.uno.engine.event.ReverseEvent;

public class ReverseCard extends Card implements Special {
    public ReverseCard(Color color) {
        super(color, Type.REVERSE);
    }

    @Override
    public ReverseEvent execute(Game game) {
        boolean clockwise = game.reverse();
        return new ReverseEvent(clockwise);
    }
}
