package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public String getHint(String secret, String guess) {

        Map<Character, Integer> secretMap = new HashMap<>();

        Set<Integer> takenIndexes = new HashSet<>();
        int bulls = 0;

        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                takenIndexes.add(i);
                bulls++;
            } else {
                char secretChar = secret.charAt(i);
                char guessChar = guess.charAt(i);

                if(!secretMap.containsKey(secretChar)) {
                    secretMap.put(secretChar, 1);
                } else {
                    secretMap.put(secretChar, secretMap.get(secretChar) + 1);
                }
            }
        }

        //System.out.println(bulls);

        int cows = 0;

        for(int i = 0; i < guess.length(); i++) {
            if(takenIndexes.contains(i)) continue;

            char potentialCow = guess.charAt(i);

            if(secretMap.containsKey(potentialCow)) {
                if(secretMap.get(potentialCow) == 0) {
                    secretMap.remove(potentialCow);
                } else {
                    cows++;
                    secretMap.put(potentialCow, secretMap.get(potentialCow) - 1);
                }
            }

        }

        //System.out.println(cows);

        return bulls + "A" + cows + "B";
    }
}
