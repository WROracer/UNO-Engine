package de.wroracer.unoengine;

import de.wroracer.unoengine.cards.*;

import java.util.ArrayList;
import java.util.List;

public class DeckUtils {
    public static List<Card> getDeck(){
        List<Card> cards = new ArrayList<>();
        for (CardColor color : CardColor.values()) {
            if (color != CardColor.BLACK){
                for (CardType number : CardType.getNumbers()) {
                    cards.add(new Card(number,color));
                    if (number!=CardType.ZERO)
                        cards.add(new Card(number,color));
                }
                cards.add(new DrawTwoCard(color));
                cards.add(new DrawTwoCard(color));
                cards.add(new ReverseCard(color));
                cards.add(new ReverseCard(color));
                cards.add(new SkipCard(color));
                cards.add(new SkipCard(color));
            }

        }
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDrawFourCard());
        }
        return cards;
    }
}
