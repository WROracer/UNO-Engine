package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;

public class SkipCard extends Card implements Special {
    public SkipCard(Color color) {
        super(color, Type.SKIP);
    }

    @Override
    public void execute(Game game) {
        game.nextPlayer();
    }
}
