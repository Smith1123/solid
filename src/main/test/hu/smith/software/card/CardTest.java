package hu.smith.software.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {
    @Test
    @DisplayName("Check constructor throwing IllegalStateException if parameter Suit is null")
    public void checkNullSuit() {
        for (Pip pip : Pip.values()) {
            assertThrows(IllegalStateException.class, () -> new Card(null, pip));
        }
    }

    @Test
    @DisplayName("Check constructor throwing IllegalStateException if parameter Pip is null")
    public void checkNullPip() {
        for (Suit suit : Suit.values()) {
            assertThrows(IllegalStateException.class, () -> new Card(suit, null));
        }
    }

    @Test
    @DisplayName("Check constructor throwing IllegalStateException if parameter Suit and Pip is null")
    public void checkNullSuitAndPip() {
        assertThrows(IllegalStateException.class, () -> new Card(null, null));
    }

    @Test
    @DisplayName("Check constructor not throwing IllegalStateException if parameter Suit and Pip is valid")
    public void checkCardConstructor() {
        for (Suit suit : Suit.values()) {
            for (Pip pip : Pip.values()) {
                assertDoesNotThrow(() -> new Card(suit, pip));
            }
        }
    }
}
