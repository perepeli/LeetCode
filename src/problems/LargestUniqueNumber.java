package problems;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int max = Integer.MIN_VALUE;

        for(int i : map.keySet()) {
            int count = map.get(i);
            if(count == 1) {
                max = Math.max(max, i);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
