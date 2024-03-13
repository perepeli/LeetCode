package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheLosersOfTheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            map.put(i, 0);
        }

        int friendIndex = 0;
        int multiplier = 1;

        while(true) {
            int friendNum = friendIndex + 1;
            map.put(friendNum, map.getOrDefault(friendNum, 0) + 1);

            if(map.get(friendNum) > 1) break;

            friendIndex = (friendIndex + (multiplier * k)) % n;
            multiplier++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(map.get(i) == 0) res.add(i);
        }

        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
