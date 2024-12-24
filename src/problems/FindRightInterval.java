package problems;

import java.util.Arrays;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[][] arr = new int[intervals.length][3];
        for(int i = 0; i < intervals.length; i++) arr[i] = new int[]{intervals[i][0], intervals[i][1], i};
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] res = new int[intervals.length];

        for(int i = 0; i < arr.length; i++) {
            int left = i;
            int right = arr.length - 1;

            while(left < right) {
                int mid = left + (right - left) / 2;

                if(arr[mid][0] >= arr[i][1]) right = mid;
                else left = mid + 1;
            }

            if(arr[left][0] >= arr[i][1]) res[arr[i][2]] = arr[left][2];
            else res[arr[i][2]] = -1;
        }

        return res;
    }
}
