package problems;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;

        for(int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                int mid = left + (right - left + 1) / 2;
                if(nums[i] + nums[mid] < k) left = mid;
                else right = mid - 1;
            }
            if(nums[i] + nums[left] < k) {
                max = Math.max(max, nums[i] + nums[left]);
            }
        }

        return max;
    }
}
