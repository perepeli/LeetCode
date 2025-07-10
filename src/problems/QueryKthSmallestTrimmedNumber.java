package problems;

import java.util.Arrays;

public class QueryKthSmallestTrimmedNumber {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int maxValLen = nums[0].length();
        int[] ans = new int[queries.length];
        int finishedTask = 0;
        String[] sorted = Arrays.copyOf(nums, nums.length);
        int digit = 1;
        while(digit <= maxValLen && finishedTask < queries.length) {
            sorted = helper(sorted, maxValLen, digit);
            for(int i=0; i<queries.length; i++) {
                if(queries[i][1] == digit) {
                    int idx = queries[i][0];
                    int j = 0;
                    for(String n : nums) {
                        if(sorted[idx-1] == n)
                            ans[i] = j;
                        j++;
                    }
                    finishedTask++;
                }
            }
            digit++;
        }
        return ans;
    }

    private String[] helper(String[] nums, int maxValLen, int digit) {
        int[] counts = new int[10];
        String[] sorted = new String[nums.length];

        for(String num : nums) {
            int n = Character.getNumericValue(num.charAt(maxValLen-digit));
            counts[n] += 1;
        }

        int startIndex = 0;
        for(int i = 0; i<counts.length; i++) {
            int c = counts[i];
            counts[i] = startIndex;
            startIndex += c;
        }

        for(String num : nums) {
            int n = Character.getNumericValue(num.charAt(maxValLen-digit));
            sorted[counts[n]] = num;
            counts[n] += 1;
        }

        return sorted;
    }
}
