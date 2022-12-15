package hu.smith.software.card;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Pip pip;

    public Card(Suit suit, Pip pip) {
        if (suit == null || pip == null) {
            throw new IllegalStateException("New card can't be initialized! Suit and pip is mandatory!");
        }

        this.suit = suit;
        this.pip = pip;
    }

    public Suit getSuit() {
        return suit;
    }

    public Pip getPip() {
        return pip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && pip == card.pip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, pip);
    }
}
