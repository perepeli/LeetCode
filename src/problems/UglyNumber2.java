package problems;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        int[] indices = {0, 0, 0};
        List<Integer> uglyArr = new ArrayList<>();
        uglyArr.add(1);

        for (int i = 1; i < n; ++i) {
            int[] nextUglies = {
                    uglyArr.get(indices[0]) * primes[0],
                    uglyArr.get(indices[1]) * primes[1],
                    uglyArr.get(indices[2]) * primes[2]
            };
            int minValue = Math.min(nextUglies[0], Math.min(nextUglies[1], nextUglies[2]));
            uglyArr.add(minValue);

            for (int j = 0; j < 3; ++j) {
                if (nextUglies[j] == minValue) {
                    indices[j]++;
                }
            }
        }

        return uglyArr.get(n - 1);
    }
}
