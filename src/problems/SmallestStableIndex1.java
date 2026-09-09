package problems;

public class SmallestStableIndex1 {
    public int firstStableIndex(int[] nums, int k) {
        int[] minRight = new int[nums.length];
        int min = nums[nums.length - 1];

        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minRight[i] = min;
        }

        int max = nums[0];

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int score = max - minRight[i];

            if(score <=k) {
                return i;
            }
        }

        return -1;
    }
}
