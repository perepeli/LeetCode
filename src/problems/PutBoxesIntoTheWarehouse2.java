package problems;

import java.util.Arrays;

public class PutBoxesIntoTheWarehouse2 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int minHeight = Integer.MAX_VALUE;
        int[] effectiveHeights = new int[n];

        for (int i = 0; i < n; ++i) {
            minHeight = Math.min(minHeight, warehouse[i]);
            effectiveHeights[i] = minHeight;
        }

        minHeight = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; --i) {
            minHeight = Math.min(minHeight, warehouse[i]);
            effectiveHeights[i] = Math.max(effectiveHeights[i], minHeight);
        }

        Arrays.sort(effectiveHeights);
        Arrays.sort(boxes);

        int count = 0;
        int boxIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (
                    boxIndex < boxes.length &&
                            boxes[boxIndex] <= effectiveHeights[i]
            ) {
                ++count;
                ++boxIndex;
            }
        }

        return count;
    }
}
