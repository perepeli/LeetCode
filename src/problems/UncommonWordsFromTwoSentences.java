package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        for(var entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        return res.toArray(String[]::new);
    }
}
