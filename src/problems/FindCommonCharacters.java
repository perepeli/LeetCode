package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, -1);

        for(String s : words) {
            int[] tempCount = new int[26];
            for(int i = 0; i < s.length(); i++) tempCount[s.charAt(i) - 'a']++;
            for(int i = 0; i < tempCount.length; i++){
                if(count[i] == -1) count[i] = tempCount[i];
                else count[i] = Math.min(count[i], tempCount[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < count.length; i++) {
            char c = (char)(i + 'a');
            for(int j = 0; j < count[i]; j++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
