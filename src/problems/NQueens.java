package problems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        boolean[][] board = new boolean[n][n];

        backtrack(n, 0, 0, board, res);
        return res;
    }

    private static void backtrack(int n, int r, int c, boolean[][] board, List<List<String>> res) {
        if(n < 0) return;
        if(n == 0) {
            List<String> temp = new ArrayList<>();
            for(boolean[] arr : board) {
                StringBuilder sb = new StringBuilder();
                for(boolean b : arr) {
                    if(b) sb.append('Q');
                    else sb.append('.');
                }
                temp.add(sb.toString());
            }
            res.add(temp);
        } else {
            for(int i = r; i < board.length; i++) {
                for(int j = c; j < board[0].length; j++) {
                    if(isValidCrosswiseAndDiagonally(i, j, board)) {
                    board[i][j] = true;

                    int newI = i + 1 < board.length ? i + 1 : 0;
                    int newJ = j + 1 < board[0].length ? j + 1 : 0;

                    backtrack(n - 1, r, j, board, res);
                    board[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean isValidCrosswiseAndDiagonally(int r, int c, boolean[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i == r) {
                    if(board[i][j]) return false;
                }

                if(j == c) {
                    if(board[i][j]) return false;
                }

                int x = Math.abs(i - r);
                int y = Math.abs(j - c);
                if(x == y) {
                    if(board[i][j] == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
