package main.views;


import main.models.Board;
import main.models.Foundation;
import main.utils.IO;

public class BoardView {

    private DeckView deckView;

    public BoardView(){
        deckView = new DeckView();
    }

    public void writeBoard(Board board){
        IO io = IO.instance();

        io.write("Baraja: ");
        deckView.writeFirstCard(board.getPlayDeck());

        io.write("Descarte: ");
        deckView.writeFirstCard(board.getPile());

        for (Foundation foundation: board.getFoundations()) {
            io.write("Palo " + foundation.getSuit().getSymbol() + ": ");
            deckView.writeFirstCard(foundation);
        }

        for (int i = 1; i <= board.getLadders().size(); i++) {
            io.write("Escalera " + i + ": ");
            deckView.writeDeck(board.getLadders().get(i - 1));
        }
    }
}
