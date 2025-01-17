package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String s : s1.split(" ")) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for(String s : s2.split(" ")) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        for(var entry : map1.entrySet()) {
            if(!map2.containsKey(entry.getKey()) && entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        for(var entry : map2.entrySet()) {
            if(!map1.containsKey(entry.getKey()) && entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        return res.stream().toArray(String[]::new);
    }
}
