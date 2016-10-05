package main.controllers;

import main.models.Card;
import main.models.Deck;
import main.models.enums.Number;
import main.views.RangeView;

public class MoveFoundationToLadderController extends MoveController {

    private final static RangeView rangeView = new RangeView();

    @Override
    Deck getSource() {
        int index = rangeView.askForRange(0, game.getBoard().getFoundations().size(), "De que palo?");
        return game.getBoard().getFoundations().get(index);
    }

    @Override
    Deck getTarget() {
        int index = rangeView.askForRange(0, game.getBoard().getLadders().size(), "A que escalera?");
        return game.getBoard().getLadders().get(index);
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        if ( !source.isEmpty() && !target.isEmpty()) {
            Card sourceCard = source.getLastCard();
            Card targetCard = target.getLastCard();
            return !sourceCard.getColor().equals(targetCard.getColor())
                    && sourceCard.getNumber().getValue() == targetCard.getNumber().getValue() - 1;
        } else if ( !source.isEmpty()) {
            return source.getLastCard().getNumber() == Number.KING;
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
