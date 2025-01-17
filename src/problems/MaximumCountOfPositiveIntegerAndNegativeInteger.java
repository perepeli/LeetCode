package problems;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        int lowerBound = binarySearch(nums, 0, false);
        int upperBound = binarySearch(nums, 0, true);

        if(upperBound != -1) {
            pos = nums.length - upperBound;
        }

        if(lowerBound != -1) {
            neg = lowerBound + 1;
        }

        return Math.max(pos, neg);
    }

    private int binarySearch(int[] nums, int target, boolean upperBound) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left + (upperBound ? 0 : 1)) / 2;

            if(upperBound) {
                if(nums[mid] > target) right = mid;
                else left = mid + 1;
            } else {
                if(nums[mid] < target)  left = mid;
                else right = mid - 1;
            }
        }

        if(upperBound) {
            if(nums[left] > target) return left;
        }

        if(!upperBound) {
            if(nums[left] < target) return left;
        }

        return -1;
    }
}
