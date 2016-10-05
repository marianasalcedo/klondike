package main.views;

import main.models.Deck;
import main.utils.IO;

public class DeckView {

    private final static CardView cardView = new CardView();
    private final static String LADDER_SYMBOL = "[";

    public void writeDeck(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            for (int i = 0; i < deck.getCards().size() - 1; i++) {
                IO.instance().write(LADDER_SYMBOL);
            }
            cardView.writeCard(deck.getLastCard());
            IO.instance().writeln();
        }
    }

    public void writeFirstCard(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            cardView.writeCard(deck.getLastCard());
            IO.instance().writeln();
        }
    }

    private void printEmptyDeck() {
        IO.instance().writeln("<VACIO>");
    }
}
