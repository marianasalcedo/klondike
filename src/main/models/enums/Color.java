package main.models.enums;

public enum Color {
    RED("Rojo"),
    BLACK("Negro");

    private String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
