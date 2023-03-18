package problems;

import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        char[] arr = s.toCharArray();

        int result = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            char currentSymbol = arr[i];
            int currentValue = map.get(currentSymbol);

            if (i == arr.length - 1) {
                result += currentValue;
            } else {
                if (currentValue < map.get(arr[i + 1])) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            }
        }

        return result;
    }
}
