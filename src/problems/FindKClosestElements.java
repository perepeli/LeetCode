package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x) right = mid;
            else left = mid + 1;
        }

        List<Integer> res = new ArrayList<>();


        if(arr[left] == x) {
            res.add(arr[left]);
            left--;
            right++;
        } else {
            left--;
        }

        while(res.size() < k && left >= 0 && right < arr.length) {
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                res.add(arr[left--]);
            } else {
                res.add(arr[right++]);
            }
        }

        while(res.size() < k && left >= 0) res.add(arr[left--]);
        while(res.size() < k && right < arr.length) res.add(arr[right++]);

        Collections.sort(res);
        return res;
    }
}
