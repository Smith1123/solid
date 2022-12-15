package hu.smith.software.poker.game;

import java.util.*;

public class Table {
    private GameEngine gameEngine;
    private GameType gameType;
    private List<Player> players;
    private List<Player> playersActive;
    private Player dealer;
    private Player smallBlind;
    private Player bigBlind;

    public Table(GameType gameType, GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.gameType = gameType;
        this.players = new ArrayList<>();
    }

    public void joinPlayer(Player newPlayer) {
        if (players.contains(newPlayer)) {
            throw new IllegalStateException("Player can't be added! Player already in the table!");
        }

        players.add(newPlayer);
    }

    public void startNewHand() {
        if (players.size() > 1) {
            evaluateDealer();
            setPlayersActive();
            gameEngine.newGame(playersActive);
        }
    }

    private void setPlayersActive() {
        playersActive = new ArrayList<>();
        for (Player player : players) {
            if (!player.isSitOut()) {
                playersActive.add(player);
            }
        }
    }

    private void evaluateDealer() {
        if (dealer == null) {
            dealer = players.get(new Random().nextInt(players.size()));
            return;
        }

        int nextDealer = players.indexOf(dealer) + 1;

//      If nextDealer index is overflow, then evaluating start from the first player
        if (nextDealer == players.size()) {
            int playerIndex = 0;
            Player player;
            do {
                player = players.get(playerIndex++);
            } while (player.isSitOut());

            dealer = player;
            return;
        }


        dealer = players.get(nextDealer);
    }

    public GameType getGameType() {
        return gameType;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getPlayersActive() {
        return playersActive;
    }

    public Player getDealer() {
        return dealer;
    }

    public Player getSmallBlind() {
        return smallBlind;
    }

    public Player getBigBlind() {
        return bigBlind;
    }
}
