package problems;

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArrays1 {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        if(nums.length > 0) arr1.add(nums[0]);
        if(nums.length > 1) arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++) {
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] res = new int[nums.length];
        int resIndex = 0;
        for(int i = 0; i < arr1.size(); i++) {
            res[resIndex++] = arr1.get(i);
        }
        for(int i = 0; i < arr2.size(); i++) {
            res[resIndex++] = arr2.get(i);
        }

        return res;
    }
}
