package de.wroracer.uno.engine;

import de.wroracer.uno.engine.card.Card;
import de.wroracer.uno.engine.card.Deck;
import de.wroracer.uno.engine.card.Special;
import de.wroracer.uno.engine.error.CardNotPlayableError;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {

    private final Deck deck;
    private final UUID id;
    private final List<Player> players;
    private boolean clockwise = true;
    private State state;
    private Player currentTurn;

    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
        id = UUID.randomUUID();

        System.out.println(deck);
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
        this.currentTurn = players.get(0);
    }

    public Card getCurrentCard() {
        return deck.currentCard();
    }


    public void play(Card card) {
        if (card.canPlayedOn(deck.currentCard())) {
            if (currentTurn.getHand().contains(card)) {
                deck.discard(card);
                currentTurn.getHand().remove(card);
                if (card instanceof Special) {
                    ((Special) card).execute(this);
                }
                nextTurn();
            }
        } else {
            throw new CardNotPlayableError(card, deck.currentCard());
        }
    }

    private void nextTurn() {
        if (currentTurn.getHand().size() == 0) {
            state = State.FINISHED;
            return;
        }
        currentTurn = nextPlayer();
    }

    public Player nextPlayer() {
        int index = players.indexOf(currentTurn);
        if (clockwise) {
            index++;
            if (index >= players.size()) {
                index = 0;
            }
        } else {
            index--;
            if (index < 0) {
                index = players.size() - 1;
            }
        }
        return players.get(index);
    }

    public void skipTurn() {
        currentTurn = nextPlayer();
    }

    public void reverse() {
        clockwise = !clockwise;
    }

    public boolean canBePlay(Card card) {
        return card.canPlayedOn(deck.currentCard());
    }

    public void draw(Player player) {
        draw(player, 1);
    }

    public void draw(Player player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.getHand().add(deck.drawCard());
        }
        if (player == currentTurn) {
            nextTurn();
        }
    }

    public UUID getId() {
        return id;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public List<Player> getPlayers() {
        return players;
    }


    public enum State {
        LOBBY,
        IN_GAME,
        FINISHED
    }
}
