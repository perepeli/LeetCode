package problems;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0] == 1 ? 1 : 0;
        int temp = max;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(nums[i - 1] == 1) {
                    temp++;
                } else {
                    temp = 1;
                }
            } else {
                temp = 0;
            }

            max = Math.max(max, temp);
        }

        return max;
    }
}
