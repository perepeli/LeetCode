package problems;

public class NeitherMinimumNorMaximum {
    public int findNonMinOrMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        for(int i : nums) {
            if(i != min & i != max) {
                return i;
            }
        }

        return -1;
    }
}
