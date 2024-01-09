package problems;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int numberOfOdds = 0;

        for(Integer i : map.values()) {
            if(i % 2 != 0) numberOfOdds++;
        }

        if(s.length() % 2 == 0) {
            if(numberOfOdds == 0) return true;
            return false;
        } else {
            if(numberOfOdds == 1) return true;
            return false;
        }
    }
}
