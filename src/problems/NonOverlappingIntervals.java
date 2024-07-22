package problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        Deque<int[]> deque = new LinkedList<>();

        for(int[] i : intervals) deque.offer(i);

        int res = 0;

        while(deque.size() > 1) {
            int[] first = deque.removeFirst();
            int[] second = deque.removeFirst();

            if(second[0] < first[1] && second[1] < first[1]) {
                res++;
                deque.addFirst(second);
            } else if(second[0] < first[1]) {
                res++;
                deque.addFirst(first);
            } else {
                deque.addFirst(second);
            }
        }

        return res;
    }
}
