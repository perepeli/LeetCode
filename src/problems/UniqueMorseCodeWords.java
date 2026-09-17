package problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet<>();

        for(String word : words) {
            StringBuilder code = new StringBuilder();

            for(int i = 0; i < word.length(); i++) {
                code.append(MORSE[word.charAt(i) - 'a']);
            }

            seen.add(code.toString());
        }

        return seen.size();
    }
}
