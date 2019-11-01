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
        board = new boolean[100][100];
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        boolean[][] board = new boolean[20][20];
        board[10][14] = true;
        board[10][13] = true;
        board[10][12] = true;
        board[10][11] = true;
        board[10][10] = true;
        board[10][9] = true;
        board[10][8] = true;
        board[10][7] = true;
        board[10][6] = true;
        board[10][5] = true;
        gameOfLife.cycleLife(board);

    }

    @Test
    void haveDeadCellWhenGameIsInitialised() {
        assertFalse(gameOfLife.cycleLife(board)[0][0]);
    }

    @Test
    void haveALiveCellWith2NeighboursWhenPlay() {
        create3AliveCells();
        assertTrue(gameOfLife.cycleLife(board)[0][1]);
    }

    private void create3AliveCells() {
        board[0][0] = true;
        board[0][1] = true;
        board[0][2] = true;
    }

    @Test
    void haveADeadCellWith1NeighboursWhenPlay() {
        create3AliveCells();
        assertFalse(gameOfLife.cycleLife(board)[0][2]);
    }

    @Test
    void haveAComplexBoardRunTwoCycles() {
        createComplexBoard();
        board = gameOfLife.cycleLife(board);
        assertTrue(gameOfLife.cycleLife(board)[1][99]);
        assertTrue(gameOfLife.cycleLife(board)[2][98]);
        assertTrue(gameOfLife.cycleLife(board)[3][98]);
        assertTrue(gameOfLife.cycleLife(board)[1][97]);
        assertTrue(gameOfLife.cycleLife(board)[2][97]);
    }

    @Test
    void haveAComplexBoardRunABunchOfCycles() {
        createComplexBoard();
        doABunchOfCycles();
        assertFalse(gameOfLife.cycleLife(board)[1][99]);
        assertFalse(gameOfLife.cycleLife(board)[2][98]);
        assertFalse(gameOfLife.cycleLife(board)[3][98]);
        assertFalse(gameOfLife.cycleLife(board)[1][97]);
        assertFalse(gameOfLife.cycleLife(board)[2][97]);
    }

    @Test
    void haveAComplexBoardRunNineOfCycles() {
        createComplexBoard();
        doNineCycles();
        assertFalse(board[1][99]);
        assertFalse(board[2][98]);
        assertFalse(board[3][98]);
        assertFalse(board[1][97]);
        assertFalse(board[2][97]);
        assertFalse(board[4][98]);
        assertFalse(board[3][96]);
        assertFalse(board[3][97]);
        assertFalse(board[5][95]);

        assertTrue(board[4][97]);
        assertTrue(board[2][96]);
        assertTrue(board[4][96]);
        assertTrue(board[3][95]);
        assertTrue(board[4][95]);
    }

    private void doNineCycles() {
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
    }

    private void doABunchOfCycles() {
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
        board = gameOfLife.cycleLife(board);
    }

    private void createComplexBoard() {
        board[0][99] = true;
        board[2][99] = true;
        board[1][98] = true;
        board[2][98] = true;
        board[1][97] = true;
    }
}
