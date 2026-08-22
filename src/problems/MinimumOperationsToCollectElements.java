package problems;

import java.util.List;

public class MinimumOperationsToCollectElements {
    public int minOperations(List<Integer> nums, int k) {

        boolean[] duplicates = new boolean[k + 1];
        int tempK = k;

        for(int i = nums.size() - 1; i >= 0; i--) {
            int curr = nums.get(i);
            if(curr <= k && !duplicates[curr]) {
                duplicates[curr] = true;
                tempK--;
                if(tempK == 0) {
                    return nums.size() - i;
                }
            }
        }

        return -1;
    }
}
