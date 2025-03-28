package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] cols = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(Character.isDigit(c)) {
                    int index = (int)(c - '0' - 1);

                    if(cols[j][index]) return false;
                    cols[j][index] = true;

                    if(rows[i][index]) return false;
                    rows[i][index] = true;

                    int boxIndex = 3 * (i / 3) + (j / 3);

                    if(boxes[boxIndex][index]) return false;
                    boxes[boxIndex][index] = true;
                }
            }
        }
        return true;
    }
}
