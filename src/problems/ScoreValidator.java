package problems;

import java.util.Map;

public class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        Map<String, Integer> map = Map.of(
                "0", 0,
                "1", 1,
                "2", 2,
                "3", 3,
                "4", 4,
                "6", 6
        );
        int score = 0;
        int counter = 0;

        for(String s : events) {
            if(counter == 10) break;
            if(map.containsKey(s)) {
                score += map.get(s);
            } else if("W".equals(s)) {
                counter++;
            } else {
                score++;
            }
        }

        return new int[]{score, counter};
    }
}
