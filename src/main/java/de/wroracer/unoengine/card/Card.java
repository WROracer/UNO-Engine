package de.wroracer.unoengine.card;

public class Card {
    protected Color color;
    protected int number;
    protected Type type;

    public Card(Color color, int number) {
        this.color = color;
        this.number = number;
        this.type = Type.byName(number + "");
    }

    protected Card(Color color, Type type) {
        this.number = -1;
        this.color = color;
        this.type = type;
    }

    public static Card of(Type type, Color color) {
        return switch (type) {
            case SKIP -> new SkipCard(color);
            case WILDE -> new WildCard();
            case REVERSE -> new ReverseCard(color);
            case DRAW_TWO -> new DrawTwoCard(color);
            case WILDE_DRAW_FOUR -> new WildDrawFourCard();
            default -> new Card(color, Integer.parseInt(type.name));
        };
    }

    public boolean canPlayedOn(Card card) {
        if (!(card.number < 0 || this.number < 0)) {
            if (this.number == card.number) {
                return true;
            }
        }
        return card.color == this.color;
    }

    @Override
    public String toString() {
        return color + type.name;
    }

    public enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK;

        @Override
        public String toString() {
            switch (this) {
                case RED -> {
                    return "R";
                }
                case BLUE -> {
                    return "B";
                }
                case BLACK -> {
                    return "Black";
                }
                case GREEN -> {
                    return "G";
                }
                case YELLOW -> {
                    return "Y";
                }
                default -> {
                    return "";
                }
            }
        }
    }

    public enum Type {
        ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), DRAW_TWO("D2"), REVERSE("R"), SKIP("S"), WILDE("W"),
        WILDE_DRAW_FOUR("WD4");
        private final String name;

        Type(String name) {
            this.name = name;
        }

        public static Type byName(String name) {
            for (Type value : values()) {
                if (value.name.equals(name)) {
                    return value;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }
    }
}
