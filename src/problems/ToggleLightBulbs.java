package problems;

import java.util.LinkedList;
import java.util.List;

public class ToggleLightBulbs {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] arr = new boolean[100];

        for(int i : bulbs) {
            arr[i - 1] = !arr[i - 1];
        }

        List<Integer> res = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == true) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
