package problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: tasks) map.put(i, map.getOrDefault(i, 0) + 1);

        int minimumRounds = 0;

        for(int count: map.values()) {
            if (count == 1) return -1;

            if(count % 3 == 0) {
                minimumRounds += count / 3;
            } else {
                minimumRounds += count / 3 + 1;

            }
        }
        return minimumRounds;
    }
}
