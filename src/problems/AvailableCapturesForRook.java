package problems;

public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int res = 0;

        int rookR = -1;
        int rookC = - 1;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R') {
                    rookR = i;
                    rookC = j;
                    break;
                }
            }
            if(rookR != -1) break;
        }

        for(int c = rookC + 1; c < board[0].length; c++) {
            char cell = board[rookR][c];
            if(cell == '.') {
                continue;
            } if(cell == 'p') {
                res++;
                break;
            } else {
                break;
            }
        }

        for(int c = rookC - 1; c >= 0; c--) {
            char cell = board[rookR][c];
            if(cell == '.') {
                continue;
            } if(cell == 'p') {
                res++;
                break;
            } else {
                break;
            }
        }

        for(int r = rookR + 1; r < board.length; r++) {
            char cell = board[r][rookC];
            if(cell == '.') {
                continue;
            } if(cell == 'p') {
                res++;
                break;
            } else {
                break;
            }
        }

        for(int r = rookR - 1; r >= 0; r--) {
            char cell = board[r][rookC];
            if(cell == '.') {
                continue;
            } if(cell == 'p') {
                res++;
                break;
            } else {
                break;
            }
        }


        return res;
    }
}
