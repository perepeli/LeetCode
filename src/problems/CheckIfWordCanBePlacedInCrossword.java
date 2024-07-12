package problems;

public class CheckIfWordCanBePlacedInCrossword {
    private static final int[][] DIR = {{0,-1},{0,1},{-1,0},{1,0}};

    public boolean placeWordInCrossword(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                for(int dirIndex = 0; dirIndex < 4; dirIndex++) {
                    if(explore(board, i, j, word, 0, dirIndex)) return true;
                }
            }
        }

        return false;
    }

    private boolean explore(char[][] board, int r, int c, String word, int index, int dirIndex) {
        if(!isValidRange(board, r, c)) return false;
        if(index == 0) {
            int prevR = r - DIR[dirIndex][0];
            int prevC = c - DIR[dirIndex][1];

            if(isValidRange(board, prevR, prevC) && board[prevR][prevC] != '#') return false;
        }

        if(index == word.length() - 1) {
            int nextR = r + DIR[dirIndex][0];
            int nextC = c + DIR[dirIndex][1];

            if(isValidRange(board, nextR, nextC) && board[nextR][nextC] != '#') return false;

            return board[r][c] == ' ' || board[r][c] == word.charAt(index);
        }

        return (board[r][c] == ' ' || board[r][c] == word.charAt(index)) && explore(board, r + DIR[dirIndex][0], c + DIR[dirIndex][1], word, index + 1, dirIndex);
    }

    private boolean isValidRange(char[][] board, int r, int c) {
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }
}
