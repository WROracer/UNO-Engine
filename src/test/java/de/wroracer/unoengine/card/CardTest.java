package de.wroracer.unoengine.card;

import org.junit.jupiter.api.Test;

import static de.wroracer.unoengine.card.Card.Color.*;
import static de.wroracer.unoengine.card.Card.Type.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardTest {

    @Test
    void canPlayedOn() {
        Card g1 = Card.of(ONE, GREEN);
        Card g2 = Card.of(TWO, GREEN);

        assertTrue(g1.canPlayedOn(g2));
        assertTrue(g2.canPlayedOn(g1));

        Card r1 = Card.of(ONE, RED);
        assertTrue(g1.canPlayedOn(r1));
        assertTrue(r1.canPlayedOn(g1));

        assertFalse(r1.canPlayedOn(g2));
        assertFalse(g2.canPlayedOn(r1));

        Card ys = Card.of(SKIP, YELLOW);
        Card y5 = Card.of(FIVE, YELLOW);

        assertTrue(ys.canPlayedOn(y5));
        assertTrue(y5.canPlayedOn(ys));

        assertFalse(g1.canPlayedOn(ys));
        assertFalse(ys.canPlayedOn(g1));
    }

}