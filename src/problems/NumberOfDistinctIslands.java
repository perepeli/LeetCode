package problems;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                bfs(grid, i, j, i, j, visited, sb);
                if(!sb.isEmpty()) set.add(sb.toString());
            }
        }

        return set.size();
    }

    private void bfs(int[][] grid, int row, int col, int i, int j, boolean[][] visited, StringBuilder sb) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if(visited[row][col] || grid[row][col] == 0) return;
        visited[row][col] = true;

        sb.append((row - i));
        sb.append((col - j));

        bfs(grid, row + 1, col, i, j, visited, sb);
        bfs(grid, row - 1, col, i, j, visited, sb);
        bfs(grid, row, col + 1, i, j, visited, sb);
        bfs(grid, row, col - 1, i, j, visited, sb);

    }
    //[[1,1,0,0,0],
    // [1,1,0,0,0],
    // [0,0,0,1,1],
    // [0,0,0,1,1]]

    //[[1,1,0,1,1],
    // [1,0,0,0,0],
    // [0,0,0,0,1],
    // [1,1,0,1,1]]
}
