package problems;

import java.util.Arrays;

public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        Arrays.fill(rows, -2);
        Arrays.fill(cols, -2);

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    if(rows[i] == -2) rows[i] = j;
                    else if(rows[i] != -1) rows[i] = -1;

                    if(cols[j] == -2) cols[j] = i;
                    else if(cols[j] != -1) cols[j] = -1;
                }
            }
        }

        int res = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    if(rows[i] == j && cols[j] == i) res++;
                }
            }
        }
        return res;
    }
}
