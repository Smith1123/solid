package hu.smith.software.poker.game;

import hu.smith.software.card.Card;

import java.util.HashSet;
import java.util.Set;

public class Hand {
    private Set<Card> cards;

    public Hand() {
        cards = new HashSet<>();
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalStateException("Card can't be added! Card is null!");
        }

        if (!cards.add(card)) {
            throw new IllegalStateException("Card can't be added! Card is already in the hand!");
        }
    }

    public Set<Card> getCards() {
        return Set.copyOf(cards);
    }
}
