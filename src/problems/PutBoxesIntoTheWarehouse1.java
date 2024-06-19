package problems;

import java.util.Arrays;

public class PutBoxesIntoTheWarehouse1 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        for(int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i], warehouse[i - 1]);
        }
        Arrays.sort(boxes);
        int res = 0;

        int w = 0;
        int b = boxes.length - 1;

        while(b >= 0 && w < warehouse.length) {
            int boxHeight = boxes[b];
            int warehouseHeight = warehouse[w];

            if(boxHeight <= warehouseHeight) {
                res++;
                b--;
                w++;
            } else {
                b--;
            }
        }

        return res;
    }
}
