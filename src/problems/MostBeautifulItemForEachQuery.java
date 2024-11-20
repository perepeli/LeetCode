package problems;

import java.util.Arrays;

public class MostBeautifulItemForEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int max = items[0][1];
        for(int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        int[] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = items.length - 1;

            while(left < right) {
                int mid = left + (right - left + 1) / 2;
                if(items[mid][0] <= queries[i]) left = mid;
                else right = mid - 1;
            }

            res[i] = items[left][0] <= queries[i] ? items[left][1] : 0;
        }

        return res;
    }
}
