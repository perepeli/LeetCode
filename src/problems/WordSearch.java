package problems;

public class WordSearch {
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int row = 0; row < this.ROWS; row++) {
            for(int col = 0; col < this.COLS; col++) {
                if(this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). Check the bottom case. */
        if(index >= word.length()) return true;

        /* Step 2). Check the boundaries */
        if(row < 0 ||  row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        /* Step 3). Explore the neighbours in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        // [0][0] -> right
        // [1][1] -> bottom
        // [2][2] -> left
        // [3][3] -> up
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};

        for(int d = 0; d < 4; d++) {
            ret = this.backtrack(row + rowOffset[d], col + colOffset[d], word, index + 1);
            if(ret) break;
        }
        /* Step 4). Clean up and return result. */
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}
