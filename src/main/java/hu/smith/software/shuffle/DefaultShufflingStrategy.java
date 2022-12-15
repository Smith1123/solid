package hu.smith.software.shuffle;

import hu.smith.software.card.Deck;
import hu.smith.software.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultShufflingStrategy implements ShufflingStrategy {
    @Override
    public List<Card> apply(Deck deck) {
        List<Card> cardList = new ArrayList<>(deck.getDeck());
        Collections.shuffle(cardList);

        return cardList;
    }
}
