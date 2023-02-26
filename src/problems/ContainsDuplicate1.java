package problems;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(map.containsKey(current)) {
                if(Math.abs(i - map.get(current)) <= k) return true;
                else map.put(current, i);
            } else {
                map.put(current, i);
            }
        }
        return false;
    }
}
