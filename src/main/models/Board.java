package main.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Deck> ladders;
    private List<Foundation> foundations;
    private Deck pile;
    private Deck playDeck;

    public Board(){
        ladders = new ArrayList<>();
        foundations = new ArrayList<>();
        pile = new Deck();
        playDeck = new Deck();
    }

    public List<Deck> getLadders() {
        return ladders;
    }

    public List<Foundation> getFoundations() {
        return foundations;
    }

    public Deck getPile() {
        return pile;
    }

    public Deck getPlayDeck() {
        return playDeck;
    }

    public Boolean finished(){
        for (Deck elem : foundations){
            if(!elem.isFull()) {
                return false;
            }
        }

        for (Deck elem: ladders){
            if(!elem.isEmpty()){
                return false;
            }
        }

        if(!pile.isEmpty() || !playDeck.isEmpty()){
            return false;
        }

        return true;
    }

}
