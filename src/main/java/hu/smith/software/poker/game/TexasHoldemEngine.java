package hu.smith.software.poker.game;

import hu.smith.software.card.Card;
import hu.smith.software.card.Deck;
import hu.smith.software.shuffle.CardDeckShuffler;
import hu.smith.software.shuffle.ShufflingStrategy;

import java.util.List;
import java.util.Set;

public class TexasHoldemEngine implements GameEngine {
    private ShufflingStrategy shufflingStrategy;

    public TexasHoldemEngine(ShufflingStrategy shufflingStrategy) {
        this.shufflingStrategy = shufflingStrategy;
    }

    @Override
    public void newGame(List<Player> players) {
        List<Card> deck = CardDeckShuffler.getInstance().shuffle(new Deck(), shufflingStrategy);

        dealToPlayers(deck, players);
        dealToPlayers(deck, players);
    }

    private void dealToPlayers(List<Card> deck, List<Player> players) {
        for (Player player : players) {
            player.getHand().addCard(deck.remove(0));
        }
    }

    @Override
    public void dealCommonCard(GameStage gameStage) {

    }

    @Override
    public void evaluateWinner() {

    }

    public GameType getGameType() {
        return GameType.TEXAS_HOLD_EM;
    }
}
