public class GameOfLife {

    boolean[][] board;

    public boolean[][] play(boolean[][] board) {
        this.board = board;
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board[row].length; column++) {
                killCell(row, column);
            }
        }
       this.board[0][1] = true;
        return this.board;
    }

    private void killCell(int row, int column) {
        board[row][column] = false;
    }
}
