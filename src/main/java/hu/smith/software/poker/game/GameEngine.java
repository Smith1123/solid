package hu.smith.software.poker.game;

import java.util.List;
import java.util.Set;

public interface GameEngine {
    void newGame(List<Player> players);

    void dealCommonCard(GameStage gameStage);

    void evaluateWinner();
}
