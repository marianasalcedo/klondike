package main.views;

import main.models.Card;
import main.utils.IO;

public class CardView {

    /**
     * @param card
     *      Card to be printed.
     * @param hiddenSymbol
     *      String to be printed if the card should be hidden.
     */
    public void writeCard(Card card, String hiddenSymbol) {
        if ( card.isHidden() ) {
            IO.instance().write(hiddenSymbol);
        } else {
            IO.instance().write("[" + card.getNumber().getSymbol() + ", " + card.getSuit().getSymbol() + ", "
                    + card.getColor().getSymbol() + "]");
        }
    }
}
