package main.controllers;

import main.models.Board;
import main.models.Deck;
import main.views.ErrorView;
import main.views.RangeView;

public class FlipController extends OperationController {

    private final RangeView rangeView = new RangeView();

    @Override
    public void execute() {
        Board board = game.getBoard();

        Deck ladder = board.getLadders().get(rangeView.askForRange(rangeView.MIN_RANGE, board.getLadders().size(), "Escalera?"));

        if ( ladder.isEmpty() ) {
            ErrorView.instance().writeError("No hay cartas en las escalera!");
        } else {
            if ( ladder.getLastCard().isHidden() ) {
                ladder.getLastCard().setHidden(false);
            } else {
                ErrorView.instance().writeError("No se puede voltear una carta descubierta!");
            }
        }
    }
}
