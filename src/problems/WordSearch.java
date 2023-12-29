package problems;

import java.util.Arrays;

public class WordSearch {
    static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] res = new boolean[]{false};
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                backtrack(board, wordArray, sb, i, j, res);
                if(res[0] == true) return true;
            }
        }

        return false;
    }

    private void backtrack(char[][] board, char[] word, StringBuilder sb, int r, int c, boolean[] res) {
        if(sb.length() == word.length) {
            res[0] = true;
        } else {
            if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
            if(board[r][c] == '*') return;
            if(board[r][c] == word[sb.length()]) {
                char prevChar = board[r][c];
                board[r][c] = '*';
                sb.append(board[r][c]);
                for(int[] dir : DIRECTIONS) {
                    backtrack(board, word, sb, r + dir[0], c + dir[1], res);
                }
                sb.deleteCharAt(sb.length() - 1);
                board[r][c] = prevChar;

            }
        }
    }
}
