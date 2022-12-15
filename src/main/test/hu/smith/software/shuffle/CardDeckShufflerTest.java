package hu.smith.software.shuffle;

import hu.smith.software.card.Card;
import hu.smith.software.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class CardDeckShufflerTest {
    @Test
    @DisplayName("Check Shuffler is shuffling")
    public void checkShufflerShuffling() {
        Deck deck = new Deck();
        List<Card> deckOriginalOrder = deck.getDeck();
        List<Card> deckShuffledOrder = CardDeckShuffler.getInstance().shuffle(deck, new DefaultShufflingStrategy());

        assertEquals(deckOriginalOrder.size(), deckShuffledOrder.size());
        assertNotEquals(deckOriginalOrder, equalTo(deckShuffledOrder));
    }
}
