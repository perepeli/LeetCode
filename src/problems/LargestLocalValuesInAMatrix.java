package problems;

public class LargestLocalValuesInAMatrix {
    private static final int[][] DIR = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int[][] largestLocal(int[][] grid) {

        int[][] res = new int[grid.length - 2][grid[0].length - 2];

        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                res[i][j] = maxLocal(grid, i + 1, j + 1);
            }
        }

        return res;
    }

    private static int maxLocal(int[][] mat, int r, int c) {
        int res = mat[r][c];

        for(int[] dir : DIR) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if(validRange(mat, newR, newC)) {
                res = Math.max(res, mat[newR][newC]);
            }
        }

        return res;
    }

    private static boolean validRange(int[][] mat, int r, int c) {
        return r >= 0 && r <= mat.length && c >= 0 && c <= mat[0].length;
    }
}
