package problems;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    public static int fib(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,0);
        m.put(1,1);

        return fibInternal(n, m);

    }

    public static int fibInternal(int num, Map<Integer, Integer> map) {
        if(map.containsKey(num)) return map.get(num);
        map.put(num, fibInternal(num-1, map) + fibInternal(num-2, map));
        return fibInternal(num-1, map) + fibInternal(num-2, map);
    }
}
