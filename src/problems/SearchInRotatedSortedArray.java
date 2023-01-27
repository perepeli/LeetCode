package problems;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);

        if(nums[minIndex] == target) return minIndex;

        int leftSearch = binarySearch(nums, 0, minIndex, target);
        if(leftSearch != -1) return leftSearch;
        int rightSearch = binarySearch(nums, minIndex, nums.length-1, target);
        return rightSearch;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        int left = l;
        int right = r;

        while(true) {
            int middle = (left + right) / 2;
            if(nums[middle] == target) return middle;
            if(middle == left) break;
            if(nums[middle] < target) left = middle;
            else right = middle;
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;

    }

    public int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(true) {
            if(nums[left] < nums[right]) return left;
            int middle = (left + right) / 2;
            if(left == middle) break;

            if(nums[middle] > nums[0]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if(nums[left] < nums[right]) return left;
        return right;
    }
}
