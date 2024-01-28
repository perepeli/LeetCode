package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return List.of(1);
        if(rowIndex == 1) return List.of(1,1);

        List<Integer> list = List.of(1, 1);
        for(int i = 1; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();

            for(int j = 0; j <= i + 1; j++) {
                if(j == 0 || j == i + 1) temp.add(1);
                else temp.add(list.get(j - 1) + list.get(j));
            }

            list = temp;
        }
        return list;
    }
}
