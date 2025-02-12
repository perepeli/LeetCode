package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] row = new int[M];
        int[] col = new int[N];

        for(int i = 0; i < arr.length; i++) {
            int[] cell = map.get(arr[i]);
            int r = cell[0];
            int c = cell[1];
            row[r]++;
            col[c]++;
            if(row[r] == N) return i;
            if(col[c] == M) return i;
        }

        return -1;
    }
}
