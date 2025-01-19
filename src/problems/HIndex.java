package problems;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;

        for(int i = 0; i < citations.length; i++) {
            hIndex = Math.max(hIndex, Math.min(citations.length - i, citations[i]));
        }

        return hIndex;
    }
}
