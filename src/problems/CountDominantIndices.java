package problems;

public class CountDominantIndices {
    public int dominantIndices(int[] nums) {
        double sum = nums[nums.length - 1];
        int size = 1;

        int count = 0;

        for(int i = nums.length - 2; i >= 0; i--) {
            double avg = sum / size;
            if(nums[i] > avg) {
                count++;
            }

            size++;
            sum += nums[i];
        }

        return count;
    }
}
