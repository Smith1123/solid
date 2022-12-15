package hu.smith.software.shuffle;

import hu.smith.software.card.Deck;
import hu.smith.software.card.Card;

import java.util.List;

public interface ShufflingStrategy {
    List<Card> apply(Deck deck);
}
