package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Map<Integer, Set<Character>>> quadrant = new HashMap<>();

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(board[row][col] != '.') {
                    int quadrantRow = map(row);
                    int quadrantCol = map(col);

                    if(!rows.containsKey(row)) rows.put(row, new HashSet<>());
                    if(!cols.containsKey(col)) cols.put(col, new HashSet<>());
                    if(!quadrant.containsKey(quadrantRow)) quadrant.put(quadrantRow, new HashMap<>());
                    if(!quadrant.get(quadrantRow).containsKey(quadrantCol)) quadrant.get(quadrantRow).put(quadrantCol, new HashSet<>());

                    if(rows.get(row).contains(board[row][col])) return false;
                    if(cols.get(col).contains(board[row][col])) return false;
                    if(quadrant.get(quadrantRow).get(quadrantCol).contains(board[row][col])) return false;

                    rows.get(row).add(board[row][col]);
                    cols.get(col).add(board[row][col]);
                    quadrant.get(quadrantRow).get(quadrantCol).add(board[row][col]);
                }
            }
        }

        return true;
    }

    private int map(int num) {
        if(num < 3) return 0;
        if(num < 6) return 1;
        if(num < 9) return 2;
        throw new IllegalArgumentException("Invalid input");
    }
}
