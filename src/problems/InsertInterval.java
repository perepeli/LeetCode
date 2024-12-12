package problems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;

        for(int i = 0; i < intervals.length; i++) {
            int[] current = new int[]{intervals[i][0], intervals[i][1]};

            if(isOverlap(current, newInterval)) {
                current = merge(current, newInterval);
                inserted = true;
            }


            if(res.size() > 0 && isOverlap(res.get(res.size() - 1), current)) {
                res.set(res.size() - 1, merge(res.get(res.size() - 1), current));
            } else {
                res.add(current);
            }
        }

        if(!inserted) {
            if(intervals.length == 0) {
                res.add(new int[]{newInterval[0], newInterval[1]});
            } else {
                int left = 0;
                int right = intervals.length - 1;

                while(left < right) {
                    int mid = left + (right - left) / 2;

                    if(intervals[mid][0] > newInterval[1]) right = mid;
                    else left = mid + 1;
                }

                if(intervals[left][0] > newInterval[1]) {
                    res.add(left, new int[]{newInterval[0], newInterval[1]});
                } else {
                    res.add(new int[]{newInterval[0], newInterval[1]});
                }
            }
        }

        int[][] ret = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }

    private boolean isOverlap(int[] a, int[] b) {
        return !(a[0] > b[1] || b[0] > a[1]);
    }

    private int[] merge(int[] a, int[] b) {
        a[0] = Math.min(a[0], b[0]);
        a[1] = Math.max(a[1], b[1]);
        return a;
    }
}
