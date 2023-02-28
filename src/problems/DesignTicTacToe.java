package problems;

public class DesignTicTacToe {
    int[][] board;

    public DesignTicTacToe(int n) {
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        if(horizontal(board, row, player)) return player;
        if(vertical(board, col, player)) return player;
        if(diagonalDown(board, player)) return player;
        if(diagonalUp(board, player)) return player;

        return 0;
    }

    private boolean horizontal(int[][] board, int row, int player) {
        for(int i = 0; i < board[0].length; i++) {
            if(board[row][i] == player) continue;
            else return false;
        }
        return true;
    }

    private boolean vertical(int[][] board, int col, int player) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == player) continue;
            else return false;
        }
        return true;
    }
    private boolean diagonalDown(int[][] board, int player) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][i] == player) continue;
            else return false;
        }
        return true;
    }
    private boolean diagonalUp(int[][] board, int player) {
        for(int i = 0; i < board.length; i++) {
            if(board[board.length-1-i][i] == player) continue;
            else return false;
        }
        return true;
    }
}
