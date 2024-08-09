package problems;

import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            List<Integer> temp = new ArrayList<>();
            while(num > 0) {
                temp.add(num % 10);
                num /= 10;
            }
            for(int j = temp.size() - 1; j >= 0; j--) {
                res.add(temp.get(j));
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
