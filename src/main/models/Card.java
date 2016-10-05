package main.models;

import main.models.enums.Color;
import main.models.enums.Number;
import main.models.enums.Suit;

public class Card {

    private Color color;
    private Number number;
    private Suit suit;
    private Boolean isHidden;

    public Card() {
    }

    public Card(Color color, Number number, Suit suit, Boolean isHidden) {
        this.color = color;
        this.number = number;
        this.suit = suit;
        this.isHidden = isHidden;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean isHidden() {
        return isHidden;
    }
}
