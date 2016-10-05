package main.controllers;

import main.models.Deck;

public class MoveFoundationToLadderController extends MoveController {
    @Override
    Deck getSource() {
        return null;
    }

    @Override
    Deck getTarget() {
        return null;
    }

    @Override
    Boolean validateMovement(Deck source, Deck target) {
        return null;
    }

    @Override
    int getCardNumber() {
        return 0;
    }

    @Override
    void postExecute(Deck source, Deck target) {

    }
}
