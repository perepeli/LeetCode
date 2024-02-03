package problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int count = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            int amount = e.getValue();

            if(amount == 1) return -1;
            if(amount % 3 == 0) {
                count += amount / 3;
                continue;
            }
            if(amount % 3 == 1) {
                count += 2;
                amount -= 4;
                count += amount / 3;
                continue;
            }
            if(amount % 3 == 2) {
                count += 1;
                amount -= 2;
                count += amount / 3;
                continue;
            }
            if(amount % 2 == 0) {
                count += amount / 2;
                continue;
            }
        }
        return count;
    }
}
