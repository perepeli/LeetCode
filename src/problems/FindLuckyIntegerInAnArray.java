package problems;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        int res = -1;

        for(var entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if(num == freq && num > res) {
                res = num;
            }
        }

        return res;
    }
}
