package problems;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    private int[][] timeLeader;

    public TopVotedCandidate(int[] persons, int[] times) {
        timeLeader = new int[times.length][2];
        Map<Integer, Integer> map = new HashMap<>();

        timeLeader[0][0] = times[0];
        timeLeader[0][1] = persons[0];

        map.put(persons[0], 1);

        int leader = persons[0];
        int votes = 1;

        for(int i = 1; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if(map.get(persons[i]) >= votes) {
                leader = persons[i];
                votes = map.get(persons[i]);
            }
            timeLeader[i][0] = times[i];
            timeLeader[i][1] = leader;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = timeLeader.length - 1;

        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(timeLeader[mid][0] <= t) left = mid;
            else right = mid - 1;
        }

        return timeLeader[left][1];
    }
}
