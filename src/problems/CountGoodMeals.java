package problems;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    final int MOD = (int) Math.pow(10, 9) + 7;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0;

        for(int num : deliciousness) {
            int pow = 1;

            for(int i = 0; i < 22; i++) {
                int toFind = pow - num;

                if(freq.containsKey(toFind)) {
                    res += freq.get(toFind);
                    res %= MOD;
                }

                pow *= 2;
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return (int) res;
    }
}
