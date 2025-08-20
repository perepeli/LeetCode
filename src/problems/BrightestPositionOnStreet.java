package problems;

import java.util.ArrayList;
import java.util.List;

public class BrightestPositionOnStreet {
    public int brightestPosition(int[][] lights) {
        final int N = lights.length;
        List<int[]> ranges = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            ranges.add(new int[]{lights[i][0] - lights[i][1], 1});
            ranges.add(new int[]{lights[i][0] + lights[i][1], -1});
        }

        ranges.sort((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int brightestPosition = Integer.MIN_VALUE;
        int brightnessAtBrightestPosition = 0;

        int tempBrightness = 0;

        for(int[] range : ranges) {
            tempBrightness += range[1];
            if(tempBrightness > brightnessAtBrightestPosition) {
                brightnessAtBrightestPosition = tempBrightness;
                brightestPosition = range[0];
            }
        }

        return brightestPosition;
    }
}
