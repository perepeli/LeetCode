package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequenceBetweenSortedArrays {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int[] arr : arrays) {
            for(int i : arr)  {
                map.put(i, map.getOrDefault(i, 0) + 1);
                if(map.get(i) == arrays.length) res.add(i);
            }
        }

        return res;
    }
}
