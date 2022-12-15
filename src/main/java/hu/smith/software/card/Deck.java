package hu.smith.software.card;

import java.util.*;

public class Deck {
    private Set<Card> deck;

    public Deck() {
        deck = new HashSet<>();
        initalizeDeck();
    }

    public List<Card> getDeck() {
        return List.copyOf(deck);
    }

    private void initalizeDeck() {
        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                deck.add(new Card(suit, pip));
            }
        }
    }
}
