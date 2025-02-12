package problems;

public class BattleshipsInABoard {
    final int[][] DIR = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int countBattleships(char[][] board) {
        int res = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    res++;
                    consume(board, i, j);
                }
            }
        }

        return res;
    }

    private void consume(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if(board[r][c] == '.') return;
        board[r][c] = '.';
        for(int[] dir : DIR) {
            consume(board, r + dir[0], c + dir[1]);
        }
    }
}
