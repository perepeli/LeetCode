package problems;

public class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {
        int [] res = new int[grid[0].length];

        for(int i=0; i < grid[0].length; i++){
            for(int j = 0; j< grid.length; j++){
                res[i] = Math.max(res[i], String.valueOf(grid[j][i]).length());
            }
        }

        return res;
    }
}
