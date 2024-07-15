package problems;

import java.util.HashMap;
import java.util.Map;

public class CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        int res = 0;

        for(String word : words) {
            String key = key(word);
            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        map.entrySet().forEach(System.out::println);

        return res;
    }

    private String key(String word) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }

}
