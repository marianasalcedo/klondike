package main.controllers;

import main.models.Game;
import main.models.enums.State;
import main.views.KlondikeView;

public class KlondikeController {

    private Game game;
    private KlondikeView klondikeView;
    private StartController startController;
    private OptionBuilder optionBuilder;

    public KlondikeController() {
        game = new Game();
        klondikeView = new KlondikeView();
        startController = new StartController();
        optionBuilder = new OptionBuilder();
    }

    public void play() {
        OperationController operationController;
        do {
            operationController = getOperationController();
            if (operationController != null) {
                operationController.setGame(game);
                operationController.execute();
            }

            if (game.getState() == State.IN_GAME) {
                klondikeView.writeKlondike(game);
            }
        } while (operationController != null);
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return optionBuilder.getOptionController();
            case EXIT:
            default:
                return null;
        }
    }
}
