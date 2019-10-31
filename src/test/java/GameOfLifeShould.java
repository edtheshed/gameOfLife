import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void haveALiveCellWith2NeighboursWhenPlay() {
        boolean[][] board = new boolean[10][10];
        board[0][0] = true;
        board[0][1] = true;
        board[1][0] = true;
        assertTrue(gameOfLife.play(board)[0][0]);
    }
}
