package problems;

import java.util.Arrays;

public class WordSearch {
    static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(backtrack(board, word, 0, i, j, visited)) return true;
            }
        }
        for(boolean[] i : visited) {
            System.out.println(Arrays.toString(i));
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if(visited[i][j]) {
            return false;
        }
        if(board[i][j] == word.charAt(index)) {
            boolean found = false;

            for(int[] direction : directions) {
                visited[i][j] = true;

                int R = direction[0];
                int C = direction[1];

                found = backtrack(board, word, index + 1, i + R, j + C, visited);

                visited[i][j] = false;

                if(found) break;
            }

            return found;
        }
        return false;
    }
}
