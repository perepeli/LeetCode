package problems;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i : candyType) set.add(i);

        int half = candyType.length / 2;

        return set.size() < half ? set.size() : half;
    }
}
