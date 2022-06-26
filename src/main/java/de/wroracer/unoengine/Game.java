package de.wroracer.unoengine;


import de.wroracer.unoengine.cards.Card;
import de.wroracer.unoengine.cards.CardColor;
import de.wroracer.unoengine.exeptions.CantPlayBlackException;
import de.wroracer.unoengine.exeptions.NotPlayableCardException;
import de.wroracer.unoengine.exeptions.PlayerHasNoCardException;
import de.wroracer.unoengine.exeptions.UnoException;

import java.util.*;

/**
 * Main Class for the UNO API to create a game.
 */
public class Game {

    private Player[] players;

    private Status status;

    private Player currentPlayer;

    private Card currentCard;

    private boolean clockWiseDirection = true;

    private List<Card> cards;

    private List<Card> disposedCards = new ArrayList<>();

    private HashMap<Player,List<Card>> playerCardHashMap = new HashMap<>();

    /**
     * @param player the amount of player for this uno round
     */
    public Game(int player){
        players = new Player[player];
        for (int i = 0; i < player; i++) {
            players[i] = new Player(i);
        }
        status = Status.LOBBY;
    }

    /**
     * @param players Pregenerated players for the round
     */
    public Game(Player[] players){
        this.players = players;
    }

    /**
     * Starts the logic for a round of UNO
     * @return the currentPlayer
     */
    public Player start(){
        status = Status.IN_GAME;
        currentPlayer = players[0];

        cards = DeckUtils.getDeck();
        Collections.shuffle(cards);
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                if (playerCardHashMap.get(player) == null){
                    List<Card> pCards = new ArrayList<>();
                    pCards.add(cards.get(0));
                    cards.remove(0);
                    playerCardHashMap.put(player,pCards);
                }else {
                    List<Card> pCards = playerCardHashMap.get(player);
                    pCards.add(cards.get(0));
                    cards.remove(0);
                    playerCardHashMap.put(player,pCards);
                }
            }
        }

        currentCard = getCard();

        return currentPlayer;
    }


    /**
     * Shutdown of the game.
     */
    public void shutdown() {
    }

    public void nextPlayer(){
        if (clockWiseDirection){
            int index = Arrays.asList(players).indexOf(currentPlayer);
            index++;
            if (index>=players.length){
                index = 0;
            }
            currentPlayer = players[index];
        }else {
            int index = Arrays.asList(players).indexOf(currentPlayer);
            index--;
            if (index<=-1){
                index = players.length-1;
            }
            currentPlayer = players[index];
        }
    }

    public Card getCurrentCard(){
        return currentCard;
    }
    public Player[] getPlayers() {
        return players;
    }

    public Status getStatus() {
        return status;
    }

    public void changeDirection() {
        this.clockWiseDirection = !this.clockWiseDirection;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void drawCard(Player playerToDraw) {
        playerCardHashMap.get(playerToDraw).add(getCard());
    }

    public void playCard(Card card,Player player) throws UnoException {
        if (checkCard(card)){
            if (playerCardHashMap.get(player).contains(card)){
                if (card.getColor() == CardColor.BLACK){
                    throw new CantPlayBlackException();
                }
                disposedCards.add(currentCard);
                card.play(this,player);
                currentCard = card;
                playerCardHashMap.get(player).remove(card);
            }else {
                throw new PlayerHasNoCardException(player,card);
            }
        }else {
            throw new NotPlayableCardException(card,currentCard);
        }
    }

    private Card getCard(){
        if (cards.size() == 0){
            cards = disposedCards;
            Collections.shuffle(cards);
            disposedCards.clear();
        }
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public boolean checkCard(Card card){
        return currentCard.isPlayable(card);
    }

    public HashMap<Player, List<Card>> getPlayerCardHashMap() {
        return playerCardHashMap;
    }


    protected void setCurrentCard(Card card){
        this.currentCard = card;
    }
}
