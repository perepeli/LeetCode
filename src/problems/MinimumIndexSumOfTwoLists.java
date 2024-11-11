package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) map.putIfAbsent(list1[i], i);

        Map<Integer, Set<String>> map2 = new HashMap<>();

        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int currSum = i + map.get(list2[i]);
                map2.putIfAbsent(currSum, new HashSet<>());
                map2.get(currSum).add(list2[i]);
                minSum = Math.min(minSum, currSum);
            }
        }

        if(map2.containsKey(minSum)) {
            return map2.get(minSum).stream().toArray(String[]::new);
        }

        return new String[0];
    }
}
