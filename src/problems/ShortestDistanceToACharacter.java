package problems;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];

        Arrays.fill(answer, Integer.MAX_VALUE);


        Integer lastOnRight = null;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == c) lastOnRight = i;
            if(lastOnRight == null) continue;
            answer[i] = lastOnRight - i;
        }

        Integer lastOnLeft = null;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) lastOnLeft = i;
            if(lastOnLeft == null) continue;
            answer[i] = Math.min(answer[i], i - lastOnLeft);
        }

        return answer;
    }
}
