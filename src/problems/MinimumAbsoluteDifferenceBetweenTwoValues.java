package problems;

public class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int lastOne = -1;
        int lastTwo = -1;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(num == 1) {
                if(lastTwo != -1) {
                    min = Math.min(min, Math.abs(i - lastTwo));
                }
                lastOne = i;
            } else if(num == 2) {
                if(lastOne != -1) {
                    min = Math.min(min, Math.abs(i - lastOne));
                }
                lastTwo = i;
            }
        }

        return (lastOne == -1 || lastTwo == -1) ? -1 : min;
    }
}
