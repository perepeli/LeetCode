package problems;

import java.util.Set;

public class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vovSet = Set.of('a', 'e', 'i', 'o', 'u');
        int[] prefix = new int[words.length];
        int[] suffix = new int[words.length];
        int count = 0;

        for(String s : words) {
            if(vovSet.contains(s.charAt(0)) && vovSet.contains(s.charAt(s.length() - 1))) {
                count++;
            }
        }

        for(int i = 1; i < words.length; i++) {
            prefix[i] = prefix[i - 1];
            String prev = words[i - 1];
            if(vovSet.contains(prev.charAt(0)) && vovSet.contains(prev.charAt(prev.length() - 1))) {
                prefix[i]++;
            }
        }

        for(int i = words.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            String next = words[i + 1];
            if(vovSet.contains(next.charAt(0)) && vovSet.contains(next.charAt(next.length() - 1))) {
                suffix[i]++;
            }
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int from = query[0];
            int to = query[1];
            res[i] = count - prefix[from] - suffix[to];
        }

        return res;
    }
}
