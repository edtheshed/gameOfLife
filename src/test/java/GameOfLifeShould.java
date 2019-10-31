import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeShould {

    private GameOfLife gameOfLife;
    private boolean[][] board;

    @BeforeEach
    void setUp() {
        gameOfLife = new GameOfLife();
        board = new boolean[10][10];
    }

    @Test
    void haveDeadCellWhenGameIsInitialised() {
        assertFalse(gameOfLife.play(board)[0][0]);
    }

    @Test
    void haveALiveCellWith2NeighboursWhenPlay() {
        board[0][0] = true;
        board[0][1] = true;
        board[1][0] = true;
        assertTrue(gameOfLife.play(board)[0][0]);
    }

    @Test
    void haveADeadCellWith1NeighboursWhenPlay() {
        board[0][0] = true;
        board[0][1] = true;
        board[0][2] = true;
        assertFalse(gameOfLife.play(board)[0][2]);
    }
}
