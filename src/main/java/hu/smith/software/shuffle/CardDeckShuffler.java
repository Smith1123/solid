package hu.smith.software.shuffle;

import hu.smith.software.card.Deck;
import hu.smith.software.card.Card;

import java.util.List;

public class CardDeckShuffler {
    private static CardDeckShuffler INSTANCE;

    private CardDeckShuffler() {}

    public synchronized static CardDeckShuffler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CardDeckShuffler();
        }

        return INSTANCE;
    }

    public List<Card> shuffle(Deck deck, ShufflingStrategy shufflingStrategy) {
        return shufflingStrategy.apply(deck);
    }
}
