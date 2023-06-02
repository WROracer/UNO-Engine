package de.wroracer.uno.engine.event;

import de.wroracer.uno.engine.Player;

public class FinishEvent extends UnoEvent {
    private final Player player;

    public FinishEvent(Player player) {
        super("finish");
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
