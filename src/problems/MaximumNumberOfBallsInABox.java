package problems;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i = lowLimit; i <= highLimit; i++) {
            int hash = 0;
            int num = i;

            while(num > 0) {
                int lastDigit = num % 10;
                hash += lastDigit;
                num /= 10;
            }

            map.put(hash, map.getOrDefault(hash, 0) + 1);

            max = Math.max(max, map.get(hash));
        }
        return max;
    }
}
