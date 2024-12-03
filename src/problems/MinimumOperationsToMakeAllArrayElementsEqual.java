package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsToMakeAllArrayElementsEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);

        List<Long> res = new ArrayList<>();

        long[] prefix = new long[nums.length];
        long[] suffix = new long[nums.length];

        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++) prefix[i] = nums[i] + prefix[i - 1];
        for(int i = nums.length - 2; i >= 0; i--) suffix[i] = nums[i] + suffix[i + 1];

        for(int i : queries) {
            long sum = 0;

            int lowerBound = binarySearchUpperOrLowerBound(nums, i, true);
            int upperBound = binarySearchUpperOrLowerBound(nums, i, false);

            if(lowerBound != -1) {
                sum += i * (long)(lowerBound + 1) - prefix[lowerBound];
            }
            if(upperBound != -1) {
                sum += suffix[upperBound] - i * (long)(nums.length - upperBound);
            }

            res.add(sum);
        }

        return res;
    }

    private int binarySearchUpperOrLowerBound(int[] nums, int target, boolean lowerBound) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if(lowerBound) {
                int mid = left + (right - left + 1) / 2;
                if(nums[mid] < target) left = mid;
                else right = mid - 1;
            } else {
                int mid = left + (right - left) / 2;
                if(nums[mid] > target) right = mid;
                else left = mid + 1;
            }
        }

        if(lowerBound) return nums[left] >= target ? -1 : left;
        else return nums[left] <= target ? -1 : left;
    }
}
