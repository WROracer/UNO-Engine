package de.wroracer.unoengine;

import de.wroracer.unoengine.card.Card;
import de.wroracer.unoengine.card.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {

    private State state;
    private final Deck deck;

    private final UUID id;
    private final List<Player> players;
    private Player currentTurn;

    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
        id = UUID.randomUUID();

        System.out.println(deck);
    }

    public static void main(String[] args) {
        new Game();
    }

    public Player addPlayer() {
        Player p = new Player();
        players.add(p);
        return p;
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    public void startGame() {
        this.state = State.IN_GAME;
        for (int i = 0; i < players.size() * 7; i++) {
            players.get(i % players.size()).getHand().add(deck.drawCard());
        }
        deck.discard(deck.drawCard());
    }

    public Card getCurrentCard() {
        return deck.currentCard();
    }

    public UUID getId() {
        return id;
    }

    public enum State {
        LOBBY,
        IN_GAME,
        FINISHED
    }
}
