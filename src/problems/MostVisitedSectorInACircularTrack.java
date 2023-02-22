package problems;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();

        int start = rounds[0];
        int end = rounds[rounds.length-1];

        if(start <= end) {
            while(start <= end) {
                list.add(start);
                start++;
            }
        } else {
            for(int i = 1; i <= end; i++) list.add(i);
            for(int i = start; i <= n; i++) list.add(i);

        }
        return list;
    }
}
