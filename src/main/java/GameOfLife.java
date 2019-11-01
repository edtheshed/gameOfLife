import javafx.geometry.Pos;

public class GameOfLife {

    boolean[][] board;
    ICellState[][] stateBoard;

    public boolean[][] cycleLife(boolean[][] board) {
        this.board = board;
        stateBoard = BoardTranslator.toStateBoard(this.board);

        prepareNextCycle();
        updateAllCells();

        this.board = BoardTranslator.toBoolBoard(stateBoard);

        return this.board;
    }

    private void updateAllCells() {
        for (int row = 0; row < stateBoard.length; row++) {
            for (int column = 0; column < stateBoard[row].length; column++) {
                stateBoard[row][column] = stateBoard[row][column].setCellState();
            }
        }
    }

    private void prepareNextCycle() {
        for (int row = 0; row < stateBoard.length; row++) {
            for (int column = 0; column < stateBoard[row].length; column++) {
                stateBoard[row][column].setNextState(amountOfNeighbours(row, column));
            }
        }
    }

    private int amountOfNeighbours(int row, int column) {
        return countRowNeighbours(row, column)
                + countColumnNeighbours(row, column)
                + countDiagonalNeighbours(row, column);
    }

    private boolean isInXBounds(int cell) {
        return (cell != 0 || cell != stateBoard.length);
    }



    private boolean isInYBounds(int cell) {
        return (cell != 0 || cell != stateBoard[0].length);
    }

    private int countRowNeighbours(int cell, int row) {
        int neighbours = 0;
        if (stateBoard[cell - 1][row].isAlive() && isInXBounds(cell))
            neighbours++;
        if (stateBoard[cell + 1][row].isAlive() && isInXBounds(cell))
            neighbours++;
        return neighbours;
    }

    private int countColumnNeighbours(int cell, int row) {
        int neighbours = 0;
        if (stateBoard[cell][row - 1].isAlive() && isInYBounds(row))
            neighbours++;
        if (stateBoard[cell][row + 1].isAlive() && isInYBounds(row))
            neighbours++;
        return neighbours;
    }


    private int countDiagonalNeighbours(int cell, int row) {
        int neighbours = 0;
        if (stateBoard[cell - 1][row - 1].isAlive() && isInXBounds(cell) && isInYBounds(row))
            neighbours++;
        if (stateBoard[cell + 1][row + 1].isAlive() && isInXBounds(cell) && isInYBounds(row))
            neighbours++;
        if (stateBoard[cell + 1][row - 1].isAlive() && isInXBounds(cell) && isInYBounds(row))
            neighbours++;
        if (stateBoard[cell - 1][row + 1].isAlive() && isInXBounds(cell) && isInYBounds(row))
            neighbours++;
        return neighbours;
    }

    public static class BoardTranslator {
        static ICellState[][] toStateBoard(boolean[][] board) {
            ICellState[][] stateBoard = new ICellState[board.length][board[0].length];
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    stateBoard[row][column] = getState(board[row][column]);
                }
            }
            return stateBoard;
        }

        private static ICellState getState(boolean isAlive) {
            if (isAlive)
                return new AliveCell();
            return new DeadCell();
        }

        static boolean[][] toBoolBoard(ICellState[][] stateBoard) {
            boolean[][] boolBoard = new boolean[stateBoard.length][stateBoard[0].length];
            for (int row = 0; row < stateBoard.length; row++) {
                for (int column = 0; column < stateBoard[row].length; column++) {
                    boolBoard[row][column] = getState(stateBoard[row][column]);
                }
            }
            return boolBoard;
        }

        private static boolean getState(ICellState cellState) {
            if (cellState.getClass() == AliveCell.class)
                return true;
            return false;
        }
    }
}
