package main.views;

import main.models.Game;
import main.utils.IO;

public class KlondikeView {

    private BoardView boardView;

    public KlondikeView() {
        boardView = new BoardView();
    }

    public void writeKlondike(Game game) {
        IO.instance().writeln("========================");
        boardView.writeBoard(game.getBoard());
        IO.instance().writeln("------------------------");
    }
}
