package hu.smith.software.poker.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TableTest {
    @Mock
    private TexasHoldemEngine gameEngine;

    @Test
    @DisplayName("Check that player join to the table")
    public void checkPlayerJoin() {
        Table table = new Table(GameType.TEXAS_HOLD_EM, gameEngine);
        String player1Name = "test1";
        String player2Name = "test2";
        assertDoesNotThrow(() -> table.joinPlayer(new Player(player1Name, 1)));
        assertDoesNotThrow(() -> table.joinPlayer(new Player(player2Name, 1)));
    }

    @Test
    @DisplayName("Check that exisiting player can't join to the table")
    public void checkExistingPlayerJoin() {
        Table table = new Table(GameType.TEXAS_HOLD_EM, gameEngine);
        String playerName = "test1";
        table.joinPlayer(new Player(playerName, 1));
        assertThrows(IllegalStateException.class, () -> table.joinPlayer(new Player(playerName, 1)));
    }

    @Test
    @DisplayName("Check when a brand new game is started dealer button is evaluated")
    public void checkDealerButtonInitialized() {
        Table table = new Table(GameType.TEXAS_HOLD_EM, gameEngine);
        String player1Name = "test1";
        String player2Name = "test2";
        Player player1 = new Player(player1Name, 1);
        Player player2 = new Player(player2Name, 1);
        table.joinPlayer(player1);
        table.joinPlayer(player2);
        table.startNewHand();
        assertNotNull(table.getDealer());
    }

    @Test
    @DisplayName("Check when new game is started dealer button is steps forward")
    public void checkDealerButtonStepsForward() {
        Table table = new Table(GameType.TEXAS_HOLD_EM, gameEngine);
        String player1Name = "test1";
        String player2Name = "test2";
        Player player1 = new Player(player1Name, 1);
        Player player2 = new Player(player2Name, 1);
        table.joinPlayer(player1);
        table.joinPlayer(player2);
        table.startNewHand();
        List<Player> players = table.getPlayers();
        int originalDealerPosition = table.getPlayers().indexOf(table.getDealer());
        table.startNewHand();
        int evaluatedDealerPosition = table.getPlayers().indexOf(table.getDealer());

        assertNotEquals(originalDealerPosition, evaluatedDealerPosition);

        if (originalDealerPosition == 0) {
            assertEquals(1, evaluatedDealerPosition);
        }

        if (originalDealerPosition == 1) {
            assertEquals(0, 1);
        }
    }
}
