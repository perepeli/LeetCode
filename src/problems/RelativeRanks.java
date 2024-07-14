package problems;

import java.util.Arrays;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int[][] sorted = new int[score.length][2]; // [place, originIndex]
        for(int i = 0; i < score.length; i++) {
            sorted[i][0] = score[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> b[0] - a[0]);

        String[] res = new String[score.length];

        for(int i = 0; i < sorted.length; i++) {
            int[] data = sorted[i];

            if(i == 0) {
                res[data[1]] = "Gold Medal";
            } else if(i == 1) {
                res[data[1]] = "Silver Medal";
            } else if(i == 2) {
                res[data[1]] = "Bronze Medal";
            } else {
                res[data[1]] = String.valueOf(i + 1);
            }
        }

        return res;
    }
}
