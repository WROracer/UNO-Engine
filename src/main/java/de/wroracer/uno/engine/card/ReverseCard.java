package de.wroracer.uno.engine.card;

import de.wroracer.uno.engine.Game;

public class ReverseCard extends Card implements Special {
    public ReverseCard(Color color) {
        super(color, Type.REVERSE);
    }

    @Override
    public void execute(Game game) {
        //TODO
    }
}
