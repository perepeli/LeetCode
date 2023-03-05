package problems;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < matches.length; i++) {
            int[] match = matches[i];

            if(!map.containsKey(match[0])) map.put(match[0], new int[2]);
            if(!map.containsKey(match[1])) map.put(match[1], new int[2]);

            map.get(match[0])[0]++;
            map.get(match[1])[1]++;
        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for(int key : map.keySet()) {
            int[] stats = map.get(key);

            if(stats[1] == 0) res.get(0).add(key);
            if(stats[1] == 1) res.get(1).add(key);
        }

        Collections.sort(res.get(0));
        Collections.sort(res.get(1));

        return res;
    }
}
