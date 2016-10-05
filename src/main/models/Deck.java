package main.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    protected List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
    }

    public Boolean isEmpty(){
        return cards.size() == 0;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> moveCards(int quantity) {
        assert quantity <= cards.size();
        List<Card> result = new ArrayList<>();
        for ( int i = 0; i < quantity; i++ ) {
            Card card = cards.remove(cards.size() - 1);
            result.add(card);
        }
        Collections.reverse(result);
        return result;
    }

    public int getHiddenCards() {
        return cards.stream().filter(card -> card.isHidden()).collect(Collectors.toList()).size();
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
