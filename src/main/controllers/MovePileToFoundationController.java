package main.controllers;

import main.models.Card;
import main.models.Deck;
import main.models.Foundation;
import main.views.RangeView;

public class MovePileToFoundationController extends  MoveController {

    private final static RangeView rangeView = new RangeView();

    @Override
    Deck getSource() {
        return game.getBoard().getPile();
    }

    @Override
    Deck getTarget() {
        int index = rangeView.askForRange(rangeView.MIN_RANGE, game.getBoard().getFoundations().size(), "A que palo?");
        return game.getBoard().getFoundations().get(index);
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        if ( !source.isEmpty() && !target.isEmpty()) {
            Card sourceCard = source.getLastCard();
            Card targetCard = target.getLastCard();
            return sourceCard.getColor().equals(targetCard.getColor())
                    && sourceCard.getSuit().equals(targetCard.getSuit())
                    && sourceCard.getNumber().getValue() == targetCard.getNumber().getValue() + 1;
        } else if ( !source.isEmpty()) {
            Foundation foundation = (Foundation) target;
            return source.getLastCard().getSuit().equals(foundation.getSuit())
                    && source.getLastCard().getColor().equals(foundation.getColor());
        }
        return false;
    }

    @Override
    int getCardNumber() {
        return 1;
    }

    @Override
    void postExecute(Deck source, Deck target) {
    }
}
