package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Integer[] sorted = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) sorted[i] = arr[i];
        Arrays.sort(sorted, (a, b) -> Math.abs(x - a) - Math.abs(x - b));
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k && i < sorted.length; i++) res.add(sorted[i]);
        Collections.sort(res);
        return res;
    }
}
