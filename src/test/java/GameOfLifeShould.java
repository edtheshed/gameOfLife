import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameOfLifeShould {

    private GameOfLife gameOfLife;

    @BeforeEach
    void setUp() {
        gameOfLife = new GameOfLife();
    }

    @Test
    void haveDeadCellWhenGameIsInitialised() {
        assertFalse(gameOfLife.play()[0][0]);
    }
}
