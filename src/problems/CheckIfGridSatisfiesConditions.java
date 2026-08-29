package problems;

public class CheckIfGridSatisfiesConditions {
    public boolean satisfiesConditions(int[][] grid) {
        for(int col = 0; col < grid[0].length; col++) {
            for(int row = 1; row < grid.length; row++) {
                if(grid[row][col] != grid[row - 1][col]) {
                    return false;
                }
            }
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 1; col < grid[0].length; col++) {
                if(grid[row][col] == grid[row][col - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
