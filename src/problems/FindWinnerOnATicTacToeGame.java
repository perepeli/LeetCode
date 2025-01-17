package problems;

import java.util.Arrays;

public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[] diagonalLeft = new int[2];
        int[] diagonalRight = new int[2];
        int[][] rows = new int[3][2];
        int[][] cols = new int[3][2];

        for(int i = 0; i < moves.length; i++) {
            if(i == 9) break;
            int[] move = moves[i];
            int r = move[0];
            int c = move[1];
            int player = i % 2 == 0 ? 0 : 1;
            String playerSign = player == 0 ? "A" : "B";

            rows[r][player]++;
            cols[c][player]++;
            if(r == c) diagonalLeft[player]++;
            if(c + r == 2) diagonalRight[player]++;

            if(rows[r][player] == 3) return playerSign;
            if(cols[c][player] == 3) return playerSign;
            if(diagonalLeft[player] == 3) return playerSign;
            if(diagonalRight[player] == 3) return playerSign;
        }

        for(int[] i : cols) System.out.println(Arrays.toString(i));

        if(moves.length < 9) return "Pending";
        return "Draw";
    }
}
