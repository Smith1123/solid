package hu.smith.software.card;

import hu.smith.software.card.Card;
import hu.smith.software.card.Deck;
import hu.smith.software.card.Pip;
import hu.smith.software.card.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.smith.software.card.Constants.FRENCH_CARD_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {
    @Test
    @DisplayName("Check when deck is created, then is initalized completely")
    public void deckIsInitalized() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                assertTrue(deck.getDeck().contains(new Card(suit, pip)));
            }
        }

        assertEquals(FRENCH_CARD_SIZE, deck.getDeck().size());
    }
}
