package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> firstSeen = new HashMap<>();
        Map<Integer, Integer> lastSeen = new HashMap<>();

        int degree = 0;

        for(int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            firstSeen.putIfAbsent(nums[i], i);
            lastSeen.put(nums[i], i);

            degree = Math.max(degree, frequencyMap.get(nums[i]));
        }

        List<Integer> higherDegreeNumbers = new ArrayList<>();

        for(Integer e : frequencyMap.keySet()) {
            if(frequencyMap.get(e) == degree) higherDegreeNumbers.add(e);
        }

        int minLength = Integer.MAX_VALUE;

        for(Integer e : higherDegreeNumbers) {
            minLength = Math.min(minLength, lastSeen.get(e) - firstSeen.get(e) + 1);
        }

        return minLength;
    }
}
