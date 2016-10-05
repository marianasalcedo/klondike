package main.controllers;

import main.models.Deck;
import main.views.ErrorView;

public class MovePileToDeckController extends MoveController {

    @Override
    Deck getSource() {
        return game.getBoard().getPile();
    }

    @Override
    Deck getTarget() {
        return game.getBoard().getPlayDeck();
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        if ( source.isEmpty() ) {
            ErrorView.instance().writeError("El descarte se encuentra vacio!");
            return false;
        }
        return true;
    }

    @Override
    int getCardNumber() {
        return 1;
    }

    @Override
    void postExecute(Deck source, Deck target) {
        target.getLastCard().setHidden(true);
    }
}
