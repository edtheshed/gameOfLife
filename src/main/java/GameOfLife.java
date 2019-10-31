public class GameOfLife {

    boolean[][] board;

    public boolean[][] cycleLife(boolean[][] board) {
        this.board = board;
        iterateBoardToKillCells();
        this.board[0][1] = true;
        return this.board;
    }

    private void iterateBoardToKillCells() {
        for (int row = 0; row < this.board.length; row++) {
            iterateColumns(row);
        }
    }

    private void iterateColumns(int row) {
        for (int column = 0; column < this.board[row].length; column++) {
            killCell(row, column);
        }
    }

    private void killCell(int row, int column) {
        board[row][column] = false;
    }
}
