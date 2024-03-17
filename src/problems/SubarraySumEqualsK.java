package problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int prefixToFind = prefixSum - k;

            if(map.containsKey(prefixToFind)) res += map.get(prefixToFind);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}
