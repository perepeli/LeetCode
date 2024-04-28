package problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        int max = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()) {
            char currentChar = s.charAt(right);

            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while(map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}
