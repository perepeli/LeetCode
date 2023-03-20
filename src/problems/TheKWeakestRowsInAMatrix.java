package problems;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<AbstractMap.SimpleEntry<int[], Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> {
                    int[] arr1 = e1.getKey();
                    int[] arr2 = e2.getKey();

                    for(int i = 0; i < arr1.length; i++) {
                        if(arr1[i] == 1 && arr2[i] == 0) return 1;
                        if(arr1[i] == 0 && arr2[i] == 1) return -1;
                    }
                    return e1.getValue() - e2.getValue();
                }
        );

        for(int i = 0; i < mat.length; i++) pq.offer(new AbstractMap.SimpleEntry<>(mat[i], i));

        int[] res = new int[k];
        int index = 0;

        while(k > 0) {
            res[index] = pq.poll().getValue();
            k--;
            index++;
        }

        return res;
    }
}
