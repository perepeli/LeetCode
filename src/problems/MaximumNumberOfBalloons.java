package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Set<Character> interest = Set.of('b', 'a', 'l', 'o', 'n');
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(interest.contains(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        if(map.size() != interest.size()) return 0;

        int max = Integer.MAX_VALUE;

        for(var entry : map.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            if(c == 'l' || c == 'o') freq /= 2;

            max = Math.min(max, freq);
        }
        System.out.println(1/2);

        return max;
    }
}
