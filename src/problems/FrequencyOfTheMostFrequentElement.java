package problems;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1;

        int right = nums.length - 1;
        int left = right;

        int tempMax = 1;
        int sum = 0;

        while(left >= 0) {
            sum += nums[left];
            int dist = right - left + 1;
            int area = nums[right] * dist;
            int K = area - sum;

            while(K > k && left < right) {
                sum -= nums[right];
                right--;

                dist = right - left + 1;
                area = nums[right] * dist;
                K = area - sum;
            }
            max = Math.max(max, dist);
            left--;
        }
        return max;
    }

}
