package problems;

import java.util.HashMap;
import java.util.Map;

public class FindValidPairOfAdjacentDigitsInString {
    public String findValidPair(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < s.length(); i++) {
            char b = s.charAt(i);
            char a = s.charAt(i - 1);

            if(a != b && map.get(a).equals(Integer.parseInt(String.valueOf(a))) && map.get(b).equals(Integer.parseInt(String.valueOf(b)))) {
                sb.append(a);
                sb.append(b);
                break;
            }
        }

        return sb.toString();
    }
}
