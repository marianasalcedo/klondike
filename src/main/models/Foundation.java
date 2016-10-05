package main.models;

import main.models.enums.Color;
import main.models.enums.Suit;

public class Foundation extends Deck {

    private Suit suit;
    private Color color;

    public Foundation(Suit suit, Color color) {
        super();
        this.suit = suit;
        this.color = color;
    }

    public Suit getSuit() {
        return suit;
    }

    public Color getColor() {
        return color;
    }
}
