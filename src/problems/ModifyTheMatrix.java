package problems;

import java.util.HashMap;
import java.util.Map;

public class ModifyTheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != -1) {
                    map.put(j, Math.max(matrix[i][j], map.getOrDefault(j, matrix[i][j])));
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1) {
                    res[i][j] = map.get(j);
                } else {
                    res[i][j] = matrix[i][j];
                }
            }
        }

        return res;
    }
}
