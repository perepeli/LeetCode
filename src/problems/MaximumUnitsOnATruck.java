package problems;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int allocatedSpace = 0;
        int units = 0;

        for(int[] i : boxTypes) {
            int freeSpace = truckSize - allocatedSpace;

            int maxAllowedNumberOfBoxes = Math.min(freeSpace, i[0]);

            units += maxAllowedNumberOfBoxes * i[1];

            allocatedSpace += maxAllowedNumberOfBoxes;
            i[0] -= maxAllowedNumberOfBoxes;

            if(i[0] > 0) break;
        }

        return units;
    }
}
