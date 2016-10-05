package main.models;

import main.models.enums.Number;

import java.util.ArrayList;
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
            result.add(cards.remove(cards.size()-1));
        }
        return result;
    }

    public int getHiddenCards() {
        return cards.stream().filter(card -> card.isHidden()).collect(Collectors.toList()).size();
    }

    /**
     * Get last card on the deck.
     * @return
     *      Last visible card on the deck.
     */
    public Card getCard() {
        return cards.get(cards.size() - 1);
    }

    public Card takeCard() {
        return cards.remove(cards.size() - 1);
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
