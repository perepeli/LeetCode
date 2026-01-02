package problems;

import java.util.Arrays;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            answer[i] = (a * num * num) + (b * num) + c;
        }

        Arrays.sort(answer);
        return answer;
    }
}
