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
        create3AliveCells();
        assertTrue(gameOfLife.play(board)[0][1]);
    }

    private void create3AliveCells() {
        board[0][0] = true;
        board[0][1] = true;
        board[0][2] = true;
    }

    @Test
    void haveADeadCellWith1NeighboursWhenPlay() {
        create3AliveCells();
        assertFalse(gameOfLife.play(board)[0][2]);
    }

}
