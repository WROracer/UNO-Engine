package de.wroracer.unoengine;

import de.wroracer.unoengine.cards.Card;
import de.wroracer.unoengine.cards.CardColor;
import de.wroracer.unoengine.cards.CardType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    int players = 5;

    @BeforeEach
    void setUp() {
        Random random = new Random();
        players = random.nextInt(10)+2;
        System.out.println("Setting up game with "+players+" players.");
        game = new Game(players);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Stopping Game");
        game.shutdown();
        game = null;
    }

    @Test
    void startTest() {
        System.out.println("    Starting with Startup Tests ...");
        System.out.print("     Checking if Status of Game is Correct");
        assertEquals(game.getStatus(),Status.LOBBY);
        System.out.println(" ✅");
        System.out.print("        Checking if all Players are generated");
        assertEquals(game.getPlayers().length,players,"Creation of players Failed.");
        for (int i = 0; i < players; i++) {
            assertNotNull(game.getPlayers()[i],"Player is null.");
        }
        System.out.println(" ✅");
        System.out.println("    Starting with Startup Tests ✅");

    }

    @Test
    void start() {
        System.out.println("    Starting with Game Start Tests ...");
        game.start();
        System.out.print("    Checking if every Player has got his Deck.");
        for (Player player : game.getPlayerCardHashMap().keySet()) {
            assertEquals(game.getPlayerCardHashMap().get(player).size(),7,"Player has got more ore to few Cards.");
        }
        System.out.println(" ✅");
        System.out.println("    Starting with Game Start Tests ✅");
    }

    @Test
    void drawCard() {
        System.out.println("    Starting with Game Card Drawing Tests ...");
        game.start();
        Player player = game.getCurrentPlayer();

        System.out.print("        Player Draws one Card");
        assertEquals(game.getPlayerCardHashMap().get(player).size(),7,"Player has got more ore to few Cards.");
        game.drawCard(player);
        assertEquals(game.getPlayerCardHashMap().get(player).size(),8,"Player has not Drawn a Card.");
        System.out.println(" ✅");

        System.out.print("        Player Draws another Card");
        assertEquals(game.getPlayerCardHashMap().get(player).size(),8,"Player has got more ore to few Cards.");
        game.drawCard(player);
        assertEquals(game.getPlayerCardHashMap().get(player).size(),9,"Player has not Drawn a Card.");
        System.out.println(" ✅");

        System.out.print("        Selecting new Player");
        game.nextPlayer();
        Player player1 = game.getCurrentPlayer();
        assertNotEquals(player1,player,"No next player where Selected.");
        System.out.println(" ✅");

        System.out.print("        Player Draws one Card");
        assertEquals(game.getPlayerCardHashMap().get(player1).size(),7,"Player has got more ore to few Cards.");
        game.drawCard(player1);
        assertEquals(game.getPlayerCardHashMap().get(player1).size(),8,"Player has not Drawn a Card.");
        System.out.println(" ✅");

        System.out.println("    Starting with Game Card Drawing Tests ✅");

    }

    @Test
    void checkCard() {
        System.out.println("    Starting with Card Checks ...");
        game.start();
        System.out.print("        Checking default Cards");
        game.setCurrentCard(new Card(CardType.ZERO, CardColor.BLUE));
        assertTrue(game.checkCard(new Card(CardType.FIVE,CardColor.BLUE)));
        assertFalse(game.checkCard(new Card(CardType.FIVE,CardColor.RED)));

        System.out.println(" ✅");

        System.out.println("    Starting with Card Checks ✅");
    }


    @Test
    void playGame() {
        System.out.println("    Starting with Game Play Tests ...");
        game.start();
        System.out.print("        Checking if Game is in Progress");
        assertEquals(game.getStatus(),Status.IN_GAME);
        System.out.println(" ✅");
        System.out.println("    Starting with Game Play Tests ✅");


    }

}