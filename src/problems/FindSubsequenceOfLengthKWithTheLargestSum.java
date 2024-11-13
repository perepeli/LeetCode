package problems;

import java.util.Arrays;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] indexVal = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) indexVal[i] = new int[]{nums[i], i};
        Arrays.sort(indexVal, (a, b) -> b[0] - a[0]);

        int[][] maxK = new int[Math.min(nums.length, k)][2];
        for(int i = 0; i < maxK.length; i++) maxK[i] = indexVal[i];
        Arrays.sort(maxK, (a, b) -> a[1] - b[1]);

        int[] res = new int[maxK.length];
        for(int i = 0; i < maxK.length; i++) {
            res[i] = maxK[i][0];
        }

        return res;
    }
}
