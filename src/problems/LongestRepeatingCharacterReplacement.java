package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(!satisfy(map, k)) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }

            res = Math.max(res, left <= right ? right - left + 1 : 0);

            right++;
        }

        return res;
    }


    private boolean satisfy(Map<Character, Integer> map, int k) {
        int maxCount = Integer.MIN_VALUE;
        int totalCount = 0;

        for(int count : map.values()) {
            maxCount = Math.max(maxCount, count);
            totalCount += count;
        }

        return (totalCount - maxCount) <= k;
    }
}
