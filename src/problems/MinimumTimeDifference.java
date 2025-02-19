package problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<int[]> list = new ArrayList<>();
        for(String s : timePoints) {
            String[] parts = s.split(":");
            list.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }

        list.sort((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < list.size(); i++) {
            int[] left = list.get(i - 1);
            int[] right = list.get(i);

            int leftMin = left[0] * 60 + left[1];
            int rightMin = right[0] * 60 + right[1];

            minDiff = Math.min(minDiff, rightMin - leftMin);
        }

        int[] left = list.get(0);

        int fromStartToLeft = 60 * left[0] + left[1];

        int[] right = list.get(list.size() - 1);

        int fromRightToEnd = ((60 * 23) - (60 * right[0])) + (59 - right[1]);

        minDiff = Math.min(minDiff, fromRightToEnd + fromStartToLeft + 1);

        return minDiff;
    }
}
