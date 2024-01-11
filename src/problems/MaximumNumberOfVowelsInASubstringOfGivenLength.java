package problems;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int max = 0;
        int window = 0;
        int index = 0;

        while(index < s.length() && index < k) {
            if(vowels.contains(s.charAt(index))) window++;
            index++;
        }

        max = window;

        for(int i = index; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i - k))) window--;
            if(vowels.contains(s.charAt(i))) window++;

            max = Math.max(max, window);
        }

        return max;
    }
}
