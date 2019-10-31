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
        boolean[][] board = new boolean[10][10];
        assertFalse(gameOfLife.play(board)[0][0]);
    }
}
