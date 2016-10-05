package main.models.enums;

public enum Suit {
    SPADE("Espadas"),
    CLUBS("Trebol"),
    HEART("Corazones"),
    DIAMOND("Diamantes");

    private String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
