package problems;

import java.util.*;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] arr : items1) map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        for(int[] arr : items2) map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);

        List<List<Integer>> res = new ArrayList<>();

        map.entrySet().forEach((e) -> res.add(Arrays.asList(e.getKey(), e.getValue())));

        Collections.sort(res, (e1, e2) -> e1.get(0) - e2.get(0));

        return res;
    }
}
