package problems;

import java.util.Set;

public class ValidWord {
    final Set<Character> vovels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean isValid(String word) {
        if(word.length() < 3) return false;

        boolean vovel = false;
        boolean cosonant = false;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(!Character.isLetterOrDigit(c)) return false;
            if(Character.isDigit(c)) continue;

            if(vovels.contains(c)) vovel = true;
            else cosonant = true;
        }

        return vovel && cosonant;
    }
}
