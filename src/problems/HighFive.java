package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map =  new HashMap<>();

        for(int[] i : items) {
            int id = i[0];
            int score = i[1];
            if(!map.containsKey(id)) map.put(id, new PriorityQueue<>());

            if(map.get(id).size() < 5) {
                map.get(id).offer(score);
            } else {
                if(map.get(id).peek() < score) {
                    map.get(id).poll();
                    map.get(id).offer(score);
                }
            }
        }

        int[][] res = new int[map.size()][2];

        int index = 0;

        for(Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
            int sum = 0;
            for(int i : e.getValue()) sum += i;
            sum /= e.getValue().size();

            res[index][0] = e.getKey();
            res[index][1] = sum;

            index++;
        }

        Arrays.sort(res, (p1, p2) -> p1[0] - p2[0]);

        return res;
    }
}
