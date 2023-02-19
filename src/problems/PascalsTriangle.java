package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // [1]
    // [1,1]
    // [1,2,1]
    // [1,3,3,1]
    // [1,4,6,4,1]

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) row.add(1);

                else  {
                    List<Integer> prev = list.get(i-1);
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            list.add(row);
        }

        return list;
    }
}
