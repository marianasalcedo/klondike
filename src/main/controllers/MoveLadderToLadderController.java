package main.controllers;

import main.models.Card;
import main.models.Deck;
import main.models.enums.Number;
import main.views.RangeView;

public class MoveLadderToLadderController extends MoveController {

    private int cardNumber;
    private int sourceIndex;

    private final static RangeView rangeView = new RangeView();

    @Override
    Deck getSource() {
        sourceIndex = rangeView.askForRange(0, game.getBoard().getLadders().size(), "De que escalera?");
        return game.getBoard().getLadders().get(sourceIndex);
    }

    @Override
    Deck getTarget() {
        int index = rangeView.askForRange(0, game.getBoard().getLadders().size(), "A que escalera?");
        return game.getBoard().getLadders().get(index);
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        int size = source.getCards().size();
        Card sourceCard = source.getCards().get(size - cardNumber);
        if ( size >= cardNumber && !target.isEmpty()) {
            Card targetCard = target.getLastCard();
            return !sourceCard.getColor().equals(targetCard.getColor())
                    && (sourceCard.getNumber().getValue() == targetCard.getNumber().getValue() - 1)
                    && size - source.getHiddenCards() >= cardNumber;
        } else if ( size >= cardNumber ) {
            return sourceCard.getNumber() == Number.KING;
        }
        return false;
    }

    @Override
    int getCardNumber() {
        cardNumber = rangeView.askForRange(0, game.getBoard().getLadders().get(sourceIndex).getCards().size(), "Cuantas cartas?") + 1;
        return cardNumber;
    }

    @Override
    void postExecute(Deck source, Deck target) {
        //Does nothing
    }
}
