package main.models;

import main.models.enums.Suit;

public class Foundation extends Deck {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }
}
