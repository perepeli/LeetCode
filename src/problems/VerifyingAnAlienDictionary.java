package problems;

import java.util.*;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i + 1);
        }

        List<String> sorted = new ArrayList<>();
        for(String s : words) sorted.add(s);

        Collections.sort(sorted, (s1, s2) -> {

            for(int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
                if(i == s1.length()) return - 1;
                if(i == s2.length()) return + 1;
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                int c1index = map.get(c1);
                int c2index = map.get(c2);

                int diff = c1index - c2index;

                if(diff != 0) return diff;
            }

            return 0;
        });
        for(int i = 0; i < words.length; i++) {
            if(!words[i].equals(sorted.get(i))) return false;
        }

        return true;
    }
}
