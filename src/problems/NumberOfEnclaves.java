package problems;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        for(int i = 0; i < grid[0].length; i++) consume(grid, 0, i);
        for(int i = 0; i < grid[0].length; i++) consume(grid, grid.length - 1, i);
        for(int i = 0; i < grid.length; i++) consume(grid, i, 0);
        for(int i = 0; i < grid.length; i++) consume(grid, i, grid[0].length -1);

        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) res++;
            }
        }

        return res;
    }

    private void consume(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if(grid[r][c] == 0) return;

        grid[r][c] = 0;

        consume(grid, r + 1, c);
        consume(grid, r - 1, c);
        consume(grid, r, c + 1);
        consume(grid, r, c - 1);
    }
}
