package problems;

import java.util.HashMap;
import java.util.Map;

public class SubstringsThatBeginAndEndWithTheSameLetter {
    public long numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();

        long res = 0;

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.containsKey(c)) res += map.get(c);
        }

        return res;
    }
}
