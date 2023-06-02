package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;
import de.wroracer.uno.engine.Player;
import de.wroracer.uno.engine.event.DrawTwoEvent;

public class DrawTwoCard extends Card implements Special {
    public DrawTwoCard(Color color) {
        super(color, Type.DRAW_TWO);
    }

    @Override
    public DrawTwoEvent execute(Game game) {
        Player drawer = game.nextPlayer();
        game.draw(drawer, 2);
        game.skipTurn();
        return new DrawTwoEvent(game.nextPlayer(), drawer);
    }
}
