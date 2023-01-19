package problems;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));

        // X[2] X
        // X[3][4] X
        // X[6][5][7] X
        // X[4][1][8][3]

        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            int size = triangle.get(i).size();

            for(int j = 0; j < size; j++) {
                if(j == 0) {
                    list.add(triangle.get(i).get(j) + dp.get(i-1).get(j));
                } else if(j == size-1) {
                    list.add(triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                } else {
                    list.add(triangle.get(i).get(j) + Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j)));
                }
            }
            dp.add(list);
        }

        int min = Integer.MAX_VALUE;

        // for(List<Integer> e: dp) {
        //     System.out.println(e);
        // }

        for(int e: dp.get(dp.size()-1)) {
            min = Math.min(min, e);
        }

        return min;
    }
}
