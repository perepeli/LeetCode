package problems;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            List<Integer> inner = nums.get(i);
            for(int j = 0; j < inner.size(); j++) {
                list.add(new int[]{i, j, inner.get(j)});
            }
        }

        list.sort((a, b) -> {
            int aCell = a[0] + a[1];
            int bCell = b[0] + b[1];
            if(aCell != bCell) return aCell - bCell;
            return b[0] - a[0];
        });

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i)[2];
        }
        return res;
    }
}
