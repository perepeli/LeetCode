package problems;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int[] counter = new int[]{0};
                    consume(grid, i, j, counter);
                    if(counter[0] > max) max = counter[0];
                }
            }
        }

        return max;
    }

    private void consume(int[][] arr, int row, int column, int[] counter) {
        if(row < 0 || column < 0 || row > arr.length-1 || column > arr[row].length-1 || arr[row][column] == 0) return;
        counter[0] = counter[0] + 1;
        arr[row][column] = 0;

        consume(arr, row-1, column, counter);
        consume(arr, row, column+1, counter);
        consume(arr, row+1, column, counter);
        consume(arr, row, column-1, counter);
    }
}
