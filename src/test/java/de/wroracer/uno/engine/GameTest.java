package de.wroracer.uno.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameTest {

    private Game game;

    @Test
    void addPlayer() {
        Player p = game.addPlayer();
        assertEquals(1, game.getPlayers().size());
        assertEquals(p, game.getPlayers().get(0));

        Player p2 = game.addPlayer();
        assertEquals(2, game.getPlayers().size());
        assertEquals(p2, game.getPlayers().get(1));
    }

    @Test
    void removePlayer() {
        Player p = game.addPlayer();
        assertEquals(1, game.getPlayers().size());
        assertEquals(p, game.getPlayers().get(0));

        game.removePlayer(p);
        assertEquals(0, game.getPlayers().size());

        Player p2 = game.addPlayer();
        assertEquals(1, game.getPlayers().size());
        assertEquals(p2, game.getPlayers().get(0));

        Player p3 = game.addPlayer();
        assertEquals(2, game.getPlayers().size());
        assertEquals(p3, game.getPlayers().get(1));

        game.removePlayer(p2);

        assertEquals(1, game.getPlayers().size());
        assertEquals(p3, game.getPlayers().get(0));
    }

    @Test
    void startGame() {
        Player p1 = game.addPlayer();
        Player p2 = game.addPlayer();
        Player p3 = game.addPlayer();
        Player p4 = game.addPlayer();

        game.startGame();

        assertEquals(7, p1.getHand().size());
        assertEquals(7, p2.getHand().size());
        assertEquals(7, p3.getHand().size());
        assertEquals(7, p4.getHand().size());

        assertEquals(4, game.getPlayers().size());
        assertNotNull(game.getCurrentCard());

    }

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void addPlayListender() {

    }
}