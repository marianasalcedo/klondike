package main.views;

import main.models.Card;
import main.utils.IO;

public class CardView {

    private final static String HIDDEN_CARD_SYMBOL = "[X,X]";

    /**
     * @param card
     *      Card to be printed.
     */
    public void writeCard(Card card) {
        if ( card.isHidden() ) {
            IO.instance().write(HIDDEN_CARD_SYMBOL);
        } else {
            IO.instance().write("[" + card.getNumber().getSymbol() + ", " + card.getSuit().getSymbol() + ", "
                    + card.getColor().getSymbol() + "]");
        }
    }
}
