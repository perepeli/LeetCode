package problems;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWord1 {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);

        int res = 0;

        for(int i = 25; i >= 0; i--) {
            res += freq[i] * (1 + ((25 - i) / 8));
        }

        return res;
    }
}
