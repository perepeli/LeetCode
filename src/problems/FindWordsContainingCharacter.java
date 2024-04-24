package problems;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            for(int j = 0; j < word.length(); j++) {
                if(word.charAt(j) == x) {
                    res.add(i);
                    break;
                }
            }
        }

        return res;
    }
}
