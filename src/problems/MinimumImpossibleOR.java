package problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumImpossibleOR {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int a : nums) s.add(a);
        int a = 1;
        while (s.contains(a))
            a <<= 1;
        return a;
    }
}
