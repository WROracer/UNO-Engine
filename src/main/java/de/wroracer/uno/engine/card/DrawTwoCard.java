package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;

public class DrawTwoCard extends Card implements Special {
    public DrawTwoCard(Color color) {
        super(color, Type.DRAW_TWO);
    }

    @Override
    public void execute(Game game) {
        game.draw(game.nextPlayer(), 2);
        game.nextPlayer();
    }
}
