package de.wroracer.uno.engine.card;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Deck {
    private final Queue<Card> draw;
    private final Stack<Card> discard;

    public Deck() {
        draw = new ArrayDeque<>();
        discard = new Stack<>();

        addCards(0, 9, Card.Color.RED);
        addCards(1, 9, Card.Color.RED);
        addCards(0, 9, Card.Color.BLUE);
        addCards(1, 9, Card.Color.BLUE);
        addCards(0, 9, Card.Color.GREEN);
        addCards(1, 9, Card.Color.GREEN);
        addCards(0, 9, Card.Color.YELLOW);
        addCards(1, 9, Card.Color.YELLOW);

        draw.add(new DrawTwoCard(Card.Color.RED));
        draw.add(new DrawTwoCard(Card.Color.RED));
        draw.add(new DrawTwoCard(Card.Color.BLUE));
        draw.add(new DrawTwoCard(Card.Color.BLUE));
        draw.add(new DrawTwoCard(Card.Color.YELLOW));
        draw.add(new DrawTwoCard(Card.Color.YELLOW));
        draw.add(new DrawTwoCard(Card.Color.GREEN));
        draw.add(new DrawTwoCard(Card.Color.GREEN));

        draw.add(new SkipCard(Card.Color.RED));
        draw.add(new SkipCard(Card.Color.RED));
        draw.add(new SkipCard(Card.Color.BLUE));
        draw.add(new SkipCard(Card.Color.BLUE));
        draw.add(new SkipCard(Card.Color.YELLOW));
        draw.add(new SkipCard(Card.Color.YELLOW));
        draw.add(new SkipCard(Card.Color.GREEN));
        draw.add(new SkipCard(Card.Color.GREEN));

        draw.add(new ReverseCard(Card.Color.RED));
        draw.add(new ReverseCard(Card.Color.RED));
        draw.add(new ReverseCard(Card.Color.BLUE));
        draw.add(new ReverseCard(Card.Color.BLUE));
        draw.add(new ReverseCard(Card.Color.YELLOW));
        draw.add(new ReverseCard(Card.Color.YELLOW));
        draw.add(new ReverseCard(Card.Color.GREEN));
        draw.add(new ReverseCard(Card.Color.GREEN));

        draw.add(new WildCard());
        draw.add(new WildCard());
        draw.add(new WildCard());
        draw.add(new WildCard());

        draw.add(new WildDrawFourCard());
        draw.add(new WildDrawFourCard());
        draw.add(new WildDrawFourCard());
        draw.add(new WildDrawFourCard());


        discard.addAll(draw);
        draw.clear();

        shuffle();
        draw.add(discard.pop());

    }

    private void addCards(int start, int end, Card.Color color) {
        for (int i = start; i <= end; i++) {
            draw.add(new Card(color, i));
        }
    }

    private void shuffle() {
        while (discard.size() > 1) {
            int index = (int) (Math.random() * discard.size());
            draw.add(discard.remove(index));
        }
    }

    public Card drawCard() {
        if (draw.size() == 0) {
            shuffle();
        }
        return draw.poll();
    }

    public void discard(Card card) {
        discard.add(card);
    }

    public Card currentCard() {
        if (discard.isEmpty()) {
            return null;
        }
        return discard.peek();
    }

    public Queue<Card> getDraw() {
        return draw;
    }

    public List<Card> getDiscard() {
        return discard;
    }
}
