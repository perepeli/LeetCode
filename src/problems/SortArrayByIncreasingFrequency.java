package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i : nums) frequency.put(i, frequency.getOrDefault(i, 0) + 1);

        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) arr[i] = nums[i];

        Arrays.sort(arr, (a, b) -> frequency.get(a) - frequency.get(b) == 0 ? b - a : frequency.get(a) - frequency.get(b));

        for(int i = 0; i < arr.length; i++) nums[i] = arr[i];

        return nums;
    }
}
