package problems;

import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;

        int res = 0;

        while(left < right) {
            if(nums.get(left) + nums.get(right) < target) {
                res += right - left;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
