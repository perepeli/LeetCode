package problems;

import java.util.Arrays;

public class SortArrayByAbsoluteValue {
    public int[] sortByAbsoluteValue(int[] nums) {
        Integer[] sorted = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, (a, b) -> {
            a = Math.abs(a);
            b = Math.abs(b);

            return a - b;
        });

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            result[i] = sorted[i];
        }

        return result;
    }
}
