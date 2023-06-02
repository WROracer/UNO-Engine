package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;
import de.wroracer.uno.engine.event.SkipEvent;

public class SkipCard extends Card implements Special {
    public SkipCard(Color color) {
        super(color, Type.SKIP);
    }

    @Override
    public SkipEvent execute(Game game) {
        game.skipTurn();

        return new SkipEvent(game.nextPlayer());
    }
}
