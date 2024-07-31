package problems;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPickWithWeight {
    int[] arr;
    int[] prefix;
    int sum;

    public RandomPickWithWeight(int[] w) {
        arr = w;
        prefix = new int[arr.length];

        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        sum = prefix[prefix.length - 1];
    }

    public int pickIndex() {
        int random = ThreadLocalRandom.current().nextInt(sum) + 1;

        int left = 0;
        int right = prefix.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(prefix[mid] >= random) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
