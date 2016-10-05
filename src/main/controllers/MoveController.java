package main.controllers;

import main.models.Card;
import main.models.Deck;
import main.views.ErrorView;

import java.util.List;

public abstract class MoveController extends OperationController {

    abstract Deck getSource();

    abstract Deck getTarget();

    abstract Boolean validateMovement(Deck source, Deck target);

    abstract int getCardNumber();

    abstract void postExecute(Deck source, Deck target);

    @Override
    public void execute() {
        Deck source = getSource();
        Deck target = getTarget();
        int numberOfCards = getCardNumber();

        if ( validateMovement(source, target) ) {
            List<Card> cards = source.moveCards(numberOfCards);
            for(Card card : cards) {
                target.addCard(card);
            }
            postExecute(source, target);
        } else {
            ErrorView.instance().writeError("Operacion no valida");
        }

    }
}
