package problems;

public class CheckIfThereIsAValidPartitionForTheArray {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            boolean valid = false;

            if(i <= nums.length - 2) {
                if(i == nums.length - 2) {
                    if(nums[i] == nums[i + 1]) {
                        valid = true;
                    }
                } else {
                    if(nums[i] == nums[i + 1] && dp[i + 2]) {
                        valid = true;
                    }
                }
            }

            if(i <= nums.length - 3) {
                if(i == nums.length - 3) {
                    if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                        valid = true;
                    }
                    if(nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                        valid = true;
                    }
                } else {
                    if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2] && dp[i + 3]) {
                        valid = true;
                    }
                    if(nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2] && dp[i + 3]) {
                        valid = true;
                    }
                }
            }

            dp[i] = valid;
        }
        return dp[0];
    }
}
