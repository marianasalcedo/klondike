package main.views;

import main.models.Deck;
import main.utils.IO;

public class DeckView {

    private final static CardView cardView = new CardView();


    public void writeDeck(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            for (int i = 0; i < deck.getCards().size() - 1; i++) {
                cardView.writeCard(deck.getCards().get(i), false);
            }
            cardView.writeCard(deck.getLastCard(), true);
            IO.instance().writeln();
        }
    }

    public void writeFirstCard(Deck deck) {
        if ( deck.isEmpty() ) {
            printEmptyDeck();
        } else {
            cardView.writeCard(deck.getLastCard(), true);
            IO.instance().writeln();
        }
    }

    private void printEmptyDeck() {
        IO.instance().writeln("<VACIO>");
    }
}
