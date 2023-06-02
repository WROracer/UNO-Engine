package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;

public class OneCardEvent extends UnoEvent {

    private final Player player;

    public OneCardEvent(Player player) {
        super("one card");
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
