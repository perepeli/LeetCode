package problems;

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            int idx = bs(grid[i]);

            res += (grid[i].length - 1) - idx + 1;
        }

        return res;
    }

    private int bs(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < 0) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
