package de.wroracer.unoengine.cards;

public enum CardColor {
    GREEN("green"),
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    BLACK("black")
    ;
    private final String name;
    CardColor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
