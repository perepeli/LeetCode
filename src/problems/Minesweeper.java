package problems;

public class Minesweeper {
    public static final int[][] DIR = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        explore(board, click[0], click[1], visited);
        return board;
    }

    private void explore(char[][] board, int row, int col, boolean[][] visited) {
        if(visited[row][col]) return;
        visited[row][col] = true;

        if(board[row][col] == 'M') {
            board[row][col] = 'X';
        } else if(board[row][col] == 'E') {
            int numMines = 0;

            for(int[] dir : DIR) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(validRange(board, newRow, newCol)) {
                    char next = board[newRow][newCol];
                    if(next == 'M' || next == 'X') {
                        numMines++;
                    }
                }
            }

            if(numMines == 0) {
                board[row][col] = 'B';
                for(int[] dir : DIR) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(validRange(board, newRow, newCol)) {
                        char next = board[newRow][newCol];
                        if(next == 'E') {
                            explore(board, newRow, newCol, visited);
                        }
                    }
                }
            } else {
                board[row][col] = (char)(numMines + '0');
            }
        }
    }

    private boolean validRange(char[][] board, int row, int col) {
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }
}
