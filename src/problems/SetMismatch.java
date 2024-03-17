package problems;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        int rep = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                rep = nums[i];
            }
            max = Math.max(max, nums[i]);
        }
        int miss = 0;
        for(int i = 1; i <= max + 1; i++) {
            if(!set.contains(i)) {
                miss = i;
                break;
            }
        }
        return new int[]{rep, miss};
    }
}
