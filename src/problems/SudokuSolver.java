package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Initialize the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = num - '1';
                    rows[i][d] = true;
                    columns[j][d] = true;
                    boxes[cellToBox(i, j)][d] = true;
                }
            }
        }

        backtrack(board, 0, 0, rows, columns, boxes);
    }

    private static boolean backtrack(char[][] board, int row, int col, boolean[][] rows, boolean[][] columns, boolean[][] boxes) {
        if (row == 9) {
            return true;
        }

        int newRow = row;
        int newCol = col + 1;
        if (newCol == 9) {
            newRow++;
            newCol = 0;
        }

        if (board[row][col] != '.') {
            return backtrack(board, newRow, newCol, rows, columns, boxes);
        }

        for (int d = 0; d < 9; d++) {
            if (!rows[row][d] && !columns[col][d] && !boxes[cellToBox(row, col)][d]) {
                board[row][col] = (char) (d + '1');
                rows[row][d] = true;
                columns[col][d] = true;
                boxes[cellToBox(row, col)][d] = true;

                if (backtrack(board, newRow, newCol, rows, columns, boxes)) {
                    return true;
                }

                board[row][col] = '.';
                rows[row][d] = false;
                columns[col][d] = false;
                boxes[cellToBox(row, col)][d] = false;
            }
        }

        return false;
    }

    private static int cellToBox(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
