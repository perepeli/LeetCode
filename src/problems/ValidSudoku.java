package problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i == j) {
                    if(!isRowValid(board, i, j)) return false;
                    if(!isColumnValid(board, i, j)) return false;
                }

                if(((i+2) % 3 == 0) && ((j+2) % 3 == 0)) {
                    if (!isSubgridValid(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean isSubgridValid(char[][] arr, int row, int col) { // only call from the middle of a subgrid
        Set<Character> set = new HashSet<>();
        if(arr[row][col] != '.') { //this
            if(!set.contains(arr[row][col])) set.add(arr[row][col]);
            else return false;
        }
        if(arr[row-1][col-1] != '.') { // top-left
            if(!set.contains(arr[row-1][col-1])) set.add(arr[row-1][col-1]);
            else return false;
        }
        if(arr[row-1][col] != '.') { // top
            if(!set.contains(arr[row-1][col])) set.add(arr[row-1][col]);
            else return false;
        }
        if(arr[row-1][col+1] != '.') { // top-right
            if(!set.contains(arr[row-1][col+1])) set.add(arr[row-1][col+1]);
            else return false;
        }
        if(arr[row][col-1] != '.') { // left
            if(!set.contains(arr[row][col-1])) set.add(arr[row][col-1]);
            else return false;
        }
        if(arr[row][col+1] != '.') { // right
            if(!set.contains(arr[row][col+1])) set.add(arr[row][col+1]);
            else return false;
        }
        if(arr[row+1][col-1] != '.') { // bottom-left
            if(!set.contains(arr[row+1][col-1])) set.add(arr[row+1][col-1]);
            else return false;
        }
        if(arr[row+1][col] != '.') { // bottom
            if(!set.contains(arr[row+1][col])) set.add(arr[row+1][col]);
            else return false;
        }
        if(arr[row+1][col+1] != '.') { // bottom right
            if(!set.contains(arr[row+1][col+1])) set.add(arr[row+1][col+1]);
            else return false;
        }

        //System.out.println(set);
        return true;
    }

    private boolean isRowValid(char[][] arr, int row, int col) { // no duplicates
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < arr[row].length; i++) {
            if(arr[row][i] == '.') continue;
            if(!set.contains(arr[row][i])) set.add(arr[row][i]);
            else return false;
        }
        return true;
    }

    private boolean isColumnValid(char[][] arr, int row, int col) { // no duplicates
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i][col] == '.') continue;
            if(!set.contains(arr[i][col])) set.add(arr[i][col]);
            else return false;
        }
        return true;
    }
}
