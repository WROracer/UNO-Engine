package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;
import de.wroracer.uno.engine.Player;
import de.wroracer.uno.engine.event.WildeDrawFourEvent;

public class WildDrawFourCard extends WildCard implements Special {
    public WildDrawFourCard() {
        this.type = Type.WILDE_DRAW_FOUR;
    }

    @Override
    public WildeDrawFourEvent execute(Game game) {
        Player drawer = game.nextPlayer();
        game.draw(drawer, 4);
        game.skipTurn();
        return new WildeDrawFourEvent(game.nextPlayer(), drawer, color);
    }
}
