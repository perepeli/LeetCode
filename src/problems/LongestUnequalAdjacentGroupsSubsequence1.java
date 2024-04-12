package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestUnequalAdjacentGroupsSubsequence1 {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();

        Set<Integer> used = new HashSet<>();

        res.add(words[0]);
        int lastGroup = groups[0];

        for(int i = 1; i < words.length; i++) {
            if(groups[i] != lastGroup) {
                lastGroup = groups[i];
                res.add(words[i]);
            }
        }

        return res;
    }
}
