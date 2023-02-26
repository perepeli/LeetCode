package problems;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        int rows = mat.length;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int key : map.keySet()) {
            if(map.get(key) == rows && key < min) min = key;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
