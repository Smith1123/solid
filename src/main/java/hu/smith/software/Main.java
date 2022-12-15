package hu.smith.software;

import hu.smith.software.card.Deck;
import hu.smith.software.shuffle.DefaultShufflingStrategy;
import hu.smith.software.shuffle.CardDeckShuffler;

public class Main {
    public void main(String[] args) {
        CardDeckShuffler.getInstance().shuffle(new Deck(), new DefaultShufflingStrategy());

    }
}
