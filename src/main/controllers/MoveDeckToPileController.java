package main.controllers;

import main.models.Board;
import main.models.Deck;
import main.views.ErrorView;

public class MoveDeckToPileController extends MoveController {

    @Override
    Deck getSource() {
        return game.getBoard().getPlayDeck();
    }

    @Override
    Deck getTarget() {
        return game.getBoard().getPile();
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        if ( source.isEmpty() ) {
            ErrorView.instance().writeError("La Baraja se encuentra vacia!");
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
        target.getLastCard().setHidden(false);
    }

}
