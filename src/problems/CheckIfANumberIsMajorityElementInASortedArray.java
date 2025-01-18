package problems;

public class CheckIfANumberIsMajorityElementInASortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int lowerBound = binarySearch(nums, target, true);
        int upperBound = binarySearch(nums, target, false);

        if(lowerBound == -1 || upperBound == -1) return false;

        return upperBound - lowerBound >= nums.length / 2;
    }

    private int binarySearch(int[] nums, int target, boolean lowerBound) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left + (lowerBound ? 0 : 1)) / 2;

            if(lowerBound) {
                if(nums[mid] >= target) right = mid;
                else left = mid + 1;
            } else {
                if(nums[mid] <= target) left = mid;
                else right = mid - 1;
            }
        }

        if(nums[left] == target) return left;
        return -1;
    }
}
