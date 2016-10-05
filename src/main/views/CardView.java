package main.views;

import main.models.Card;
import main.utils.IO;

public class CardView {

    private final static String LAST_CARD_HIDDEN_SYMBOL = "[X,X]";
    private final static String LADDER_CARD_HIDDEN_SYMBOL = "[";

    public void writeCard(Card card, Boolean isLastCard) {
        if ( card.isHidden() ) {
            IO.instance().write( isLastCard ? LAST_CARD_HIDDEN_SYMBOL : LADDER_CARD_HIDDEN_SYMBOL);
        } else {
            IO.instance().write("[" + card.getNumber().getSymbol() + ", " + card.getSuit().getSymbol() + ", "
                    + card.getColor().getSymbol() + "]");
        }
    }
}
