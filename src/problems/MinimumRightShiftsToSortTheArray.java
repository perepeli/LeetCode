package problems;

import java.util.List;

public class MinimumRightShiftsToSortTheArray {
    public int minimumRightShifts(List<Integer> nums) {
        int minIndex = 0;
        int minElement = Integer.MAX_VALUE;

        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) < minElement) {
                minElement = nums.get(i);
                minIndex = i;
            }
        }
        int tempIndex = minIndex;
        int[] tempArr = new int[nums.size()];

        for(int i = 0; i < nums.size(); i++) {
            tempArr[i] = nums.get(tempIndex);
            tempIndex = (tempIndex + 1) % nums.size();
        }

        for(int i = 1; i < nums.size(); i++) {
            if(tempArr[i] < tempArr[i - 1]) return -1;
        }

        if(minIndex == 0) return 0;
        return nums.size() - minIndex;
    }
}
