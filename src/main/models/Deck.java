package main.models;

import main.models.enums.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    protected List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
    }

    public Boolean isFull(){
        return cards.size() == Number.values().length;
    }

    public Boolean isEmpty(){
        return cards.size() == 0;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
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
