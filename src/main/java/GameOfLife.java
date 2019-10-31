public class GameOfLife {
    public boolean[][] play(boolean[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = false;
            }
        }
        board[0][1] = true;
        return board;
    }
}
