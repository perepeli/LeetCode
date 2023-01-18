package problems;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStaris {
    public int climbStairs(int n) {
        // if(n == 1) return 1;
        // if(n == 2) return 2;

        // return climbStairs(n - 2) + climbStairs(n - 1);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);

        return climbStairsRecursive(n, map);
    }

    private int climbStairsRecursive(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n)) return map.get(n);

        map.put(n, climbStairsRecursive(n-1, map) + climbStairsRecursive(n-2, map));

        return map.get(n);
    }
    // public int climbStairs(int n) {
    //     int[] arr = new int[n];

    //     for(int i = arr.length-1; i >= 0; i--) {
    //         if(i == arr.length-1) {
    //             arr[i] = 1;
    //             continue;
    //         }
    //         if(i == arr.length-2) {
    //             arr[i] = 2;
    //             continue;
    //         }
    //         arr[i] = arr[i+1] + arr[i+2];
    //     }

    //     //System.out.println(Arrays.toString(arr));

    //     return arr[0];
    // }
}
