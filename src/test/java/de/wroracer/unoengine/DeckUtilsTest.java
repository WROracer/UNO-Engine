package de.wroracer.unoengine;

import de.wroracer.unoengine.cards.Card;
import de.wroracer.unoengine.cards.CardColor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckUtilsTest {

    @Test
    void getDeck() {
        List<Card> cards = DeckUtils.getDeck();
        List<Card> blueNumbers = cards.stream().filter(c->c.getColor().equals(CardColor.BLUE)&&c.getType().isNumber()).collect(Collectors.toList());
        List<Card> blueSpecials = cards.stream().filter(c->c.getColor().equals(CardColor.BLUE)&&!c.getType().isNumber()).collect(Collectors.toList());

        List<Card> redNumbers = cards.stream().filter(c->c.getColor().equals(CardColor.RED)&&c.getType().isNumber()).collect(Collectors.toList());
        List<Card> redSpecials = cards.stream().filter(c->c.getColor().equals(CardColor.RED)&&!c.getType().isNumber()).collect(Collectors.toList());

        List<Card> greenNumbers = cards.stream().filter(c->c.getColor().equals(CardColor.GREEN)&&c.getType().isNumber()).collect(Collectors.toList());
        List<Card> greenSpecials = cards.stream().filter(c->c.getColor().equals(CardColor.GREEN)&&!c.getType().isNumber()).collect(Collectors.toList());

        List<Card> yellowNumbers = cards.stream().filter(c->c.getColor().equals(CardColor.YELLOW)&&c.getType().isNumber()).collect(Collectors.toList());
        List<Card> yellowSpecials = cards.stream().filter(c->c.getColor().equals(CardColor.YELLOW)&&!c.getType().isNumber()).collect(Collectors.toList());

        List<Card> blackCards = cards.stream().filter(c->c.getColor().equals(CardColor.BLACK)).collect(Collectors.toList());

        assertAll("Deck cards",
                () -> assertEquals(cards.size(),108,"Not Enough Cards"),
                () -> assertEquals(blueNumbers.size(),19,"Not Enough Blue Number Cards"),
                () -> assertEquals(redNumbers.size(),19,"Not Enough Red Number Cards"),
                () -> assertEquals(greenNumbers.size(),19,"Not Enough Green Number Cards"),
                () -> assertEquals(yellowNumbers.size(),19,"Not Enough Yellow Number Cards"),

                () -> assertEquals(blueSpecials.size(),6,"Not Enough Blue  Special Cards"),
                () -> assertEquals(redSpecials.size(),6,"Not Enough Red  Special Cards"),
                () -> assertEquals(greenSpecials.size(),6,"Not Enough Green  Special Cards"),
                () -> assertEquals(yellowSpecials.size(),6,"Not Enough Yellow Special Cards"),

                () -> assertEquals(blackCards.size(),8,"Not Enough Black Cards")

        );
    }
}