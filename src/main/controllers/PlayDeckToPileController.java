package main.controllers;

import main.models.Board;
import main.models.Card;

import java.util.Collections;

public class PlayDeckToPileController extends OperationController {

    @Override
    public void execute() {
        Board board = game.getBoard();

        if ( board.getPlayDeck().isEmpty() ) {
            board.getPlayDeck().setCards(board.getPile().getCards());
            Collections.reverse(board.getPlayDeck().getCards());

            for(Card card : board.getPlayDeck().getCards()) {
                card.setHidden(true);
            }
        }

        Card card = board.getPlayDeck().takeCard();
        card.setHidden(false);
        board.getPile().addCard(card);
    }

}
