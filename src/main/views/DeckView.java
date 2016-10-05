package main.views;

import main.models.Deck;
import main.utils.IO;

public class DeckView {

    private final static CardView cardView = new CardView();
    private final static String DEFAULT_HIDDEN_SYMBOL = "[X,X]";
    private final static String LADDER_HIDDEN_SYMBOL = "[";

    public void writeDeck(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            deck.getCards().forEach(card -> cardView.writeCard(card, LADDER_HIDDEN_SYMBOL));
            IO.instance().writeln();
        }
    }

    public void writeFirstCard(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            cardView.writeCard(deck.getCard(), DEFAULT_HIDDEN_SYMBOL);
            IO.instance().writeln();
        }
    }

    private void printEmptyDeck() {
        IO.instance().writeln("<VACIO>");
    }
}
