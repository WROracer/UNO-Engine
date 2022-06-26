package de.wroracer.unoengine.cards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CardType {
    ZERO("zero",0,Card.class),
    ONE("one",1,Card.class),
    TWO("two",2,Card.class),
    THREE("three",3,Card.class),
    FOUR("four",4,Card.class),
    FIVE("five",5,Card.class),
    SIX("six",6,Card.class),
    SEVEN("seven",7,Card.class),
    EIGHT("eight",8,Card.class),
    NINE("nine",9,Card.class),
    REVERSE("reverse",ReverseCard.class),
    DRAW_TWO("draw two",DrawTwoCard.class),
    SKIP("skip",SkipCard.class),
    WILD("wild",WildCard.class),
    WILD_DRAW_FOUR("wild draw four",WildDrawFourCard.class),
    ;

    public static List<CardType> getNumbers(){
        return Arrays.stream(CardType.values()).filter(CardType::isNumber).collect(Collectors.toList());
    }
    public static List<CardType> getSpecials(){
        return Arrays.stream(CardType.values()).filter(c->!c.isNumber()).collect(Collectors.toList());
    }

    private String name;
    private Class<? extends Card> card;
    private int number = -1;

    CardType(String name,Class<? extends Card> card){
        this.name = name;
        this.card = card;
    }

    CardType(String name,int number,Class<? extends Card> card){
        this.name = name;
        this.number = number;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isNumber(){
        return number > -1;
    }

    public Class<? extends Card> getCard() {
        return card;
    }
}
