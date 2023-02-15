package problems;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Set<Integer> set = new LinkedHashSet<>();

        for(int[] e : intervals) {
            for(int i = e[0]; i <= e[1]; i++) {
                set.add(i);
            }
        }

        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
        int left = 0;
        int right = 1;

        List<int[]> list = new ArrayList<>();

        while(right < arr.length) {
            if(arr[right-1] == arr[right]-1) {
                if(right == arr.length-1) {
                    list.add(new int[]{arr[left], arr[right]});
                }
                right++;
            } else {
                list.add(new int[]{arr[left], arr[right-1]});
                left = right;
                right = left+1;
            }
        }

        return list.toArray(new int[0][0]) ;
    }
}
