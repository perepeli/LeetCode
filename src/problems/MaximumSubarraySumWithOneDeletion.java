package problems;

import java.util.Arrays;

public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];

        prefix[0] = arr[0];
        suffix[arr.length - 1] = arr[arr.length - 1];

        for(int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i], arr[i] + suffix[i + 1]);
        }

        for(int i = 1; i < arr.length; i++) {
            prefix[i] = Math.max(arr[i], arr[i] + prefix[i - 1]);
        }

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            res = Math.max(res, arr[i]);
            if(i > 0) res = Math.max(res, prefix[i - 1]);
            if(i < arr.length - 1) res = Math.max(res, suffix[i + 1]);
            if(i > 0 && i < arr.length - 1) res = Math.max(res, prefix[i - 1] + suffix[i + 1]);
            if(i > 0 && i < arr.length - 1) res = Math.max(res, arr[i] + prefix[i - 1] + suffix[i + 1]);
        }

        return res;
    }
}
