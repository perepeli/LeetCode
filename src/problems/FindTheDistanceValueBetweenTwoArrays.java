package problems;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int res = 0;

        for(int i : arr1) {
            int left = 0;
            int right = arr2.length - 1;

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr2[mid] >= i) right = mid;
                else left = mid + 1;
            }

            if(Math.abs(arr2[left] - i) <= d || (left - 1 >= 0 && Math.abs(arr2[left - 1] - i) <= d)) continue;
            res++;
        }

        return res;
    }
}
