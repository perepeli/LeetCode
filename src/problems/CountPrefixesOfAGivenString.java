package problems;

import java.util.HashSet;
import java.util.Set;

public class CountPrefixesOfAGivenString {
    public int countPrefixes(String[] words, String s) {
        Set<String> prefixes = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            prefixes.add(sb.toString());
        }

        int res = 0;

        for(String str : words) {
            if(prefixes.contains(str)) {
                res++;
            }
        }


        return res;
    }
}
