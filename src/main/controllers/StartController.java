package main.controllers;

import main.models.Board;
import main.models.Card;
import main.models.Deck;
import main.models.Foundation;
import main.models.enums.Color;
import main.models.enums.Number;
import main.models.enums.State;
import main.models.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartController extends OperationController {

    private final static int LADDER_NUMBER = 7;

    public StartController() {
        super();
    }

    @Override
    public void execute() {
        assert this.game != null;
        assert this.game.getState() == State.INITIAL;
        this.game.setState(State.IN_GAME);
        initializeBoard();
    }

    private void initializeBoard() {
        Board board = game.getBoard();
        List<Card> cards = new ArrayList<>();

        for (Suit suit: Suit.values()) {
            Color suitColor;
            if ( suit == Suit.HEART || suit == Suit.DIAMOND) {
                suitColor = Color.RED;
            } else {
                suitColor = Color.BLACK;
            }
            for (Number number: Number.values()) {
                cards.add(new Card(suitColor, number, suit, true));
            }
        }

        Collections.shuffle(cards);

        initializeLadders(board, cards);

        initializeFoundations(board);

        //Set remaining cards to the play deck
        for (Card card: cards) {
            board.getPlayDeck().addCard(card);
        }
    }

    private void initializeLadders(Board board, List<Card> cards) {
        for (int i = LADDER_NUMBER; i > 0; i--) {
            Deck ladder = new Deck();
            for ( int j = 0; j < i; j++ ) {
                ladder.addCard(cards.remove(0));
            }
            ladder.getLastCard().setHidden(false);
            board.getLadders().add(ladder);
        }
    }

    private void initializeFoundations(Board board) {
        for (Suit suit : Suit.values()) {
            Color suitColor;
            if ( suit == Suit.HEART || suit == Suit.DIAMOND) {
                suitColor = Color.RED;
            } else {
                suitColor = Color.BLACK;
            }
            Foundation foundation = new Foundation(suit, suitColor);
            board.getFoundations().add(foundation);
        }
    }

}
