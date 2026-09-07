package problems;

public class LimitOccurrencesInSortedArray {
    public int[] limitOccurrences(int[] nums, int k) {
        int size = 1;
        int tempK = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                tempK++;
                if(tempK <= k) size++;
            } else {
                tempK = 1;
                size++;
            }
        }

        tempK = 1;

        int[] res = new int[size];
        res[0] = nums[0];
        int index = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                tempK++;
                if(tempK <= k) {
                    res[index++] = nums[i];
                }
            } else {
                tempK = 1;
                res[index++] = nums[i];
            }
        }


        return res;
    }
}
