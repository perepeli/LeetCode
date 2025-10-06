package problems;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> rez = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || k != 0) {

            if (i >= 0) {
                k += num[i--];
            }
            rez.add(k % 10);
            k /= 10;
        }

        return rez;
    }
}
