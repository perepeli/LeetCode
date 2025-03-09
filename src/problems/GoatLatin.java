package problems;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    private static Set<Character> vowels =
            new HashSet<>() {
                {
                    add('a');
                    add('e');
                    add('i');
                    add('o');
                    add('u');
                    add('A');
                    add('E');
                    add('I');
                    add('O');
                    add('U');
                }
            };

    public String toGoatLatin(String sentence) {
        String suffix = "";
        StringBuilder sb = new StringBuilder();

        for(String s : sentence.split(" ")) {
            suffix += 'a';

            if(!vowels.contains(s.charAt(0))) {
                s = s.substring(1) + s.charAt(0);
            }

            sb.append(s).append("ma").append(suffix).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
