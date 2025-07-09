package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int boxIndex = i / 3 * 3 + j / 3;

                if(board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);

                    if(rows[i][num] == 1) return false;
                    rows[i][num]++;

                    if(cols[j][num] == 1) return false;
                    cols[j][num]++;

                    if(boxes[boxIndex][num] == 1) return false;
                    boxes[boxIndex][num]++;
                }
            }
        }

        return true;
    }
}
