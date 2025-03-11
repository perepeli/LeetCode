package problems;

import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int N = grid.length;
        int missing = -1;
        int repeated = -1;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] row : grid) {
            for (int num : row) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        for(int i = 1; i <= N * N; i++) {
            if(!freq.containsKey(i)) {
                missing = i;
            } else if(freq.get(i) == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
