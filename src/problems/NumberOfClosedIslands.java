package problems;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int R = grid.length;
        int C = grid[0].length;

        for(int r = 0; r < R; r++) {
            if(grid[r][0] == 0) consume(grid, r, 0);
            if(grid[r][C-1] == 0) consume(grid, r, C-1);
        }

        for(int c = 0; c < C; c++) {
            if(grid[0][c] == 0) consume(grid, 0, c);
            if(grid[R-1][c] == 0) consume(grid, R-1, c);
        }

        int res = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 0) {
                    consume(grid, r, c);
                    res++;
                }
            }
        }

        return res;
    }

    private void consume(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if(grid[r][c] == 1) return;

        grid[r][c] = 1;

        consume(grid, r, c+1);
        consume(grid, r+1, c);
        consume(grid, r, c-1);
        consume(grid, r-1, c);
    }
}
