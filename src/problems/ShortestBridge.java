package problems;

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {
    private int[][] DIR = {{0,-1},{0,1},{-1,0},{1,0}};

    public int shortestBridge(int[][] grid) {
        int consumedIslands = 0;
        List<int[]> firstIslandShores = new ArrayList<>();
        List<int[]> secondIslandShores = new ArrayList<>();

        for(int r = 0; r < grid.length; r++) {
            if (consumedIslands == 2) break;;

            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    if(consumedIslands == 0) dfsConsume(grid, r, c, firstIslandShores);
                    if(consumedIslands == 1) dfsConsume(grid, r, c, secondIslandShores);

                    consumedIslands++;
                    if (consumedIslands == 2) break;
                }
            }
        }

        int shortestBridge = Integer.MAX_VALUE;

        for(int[] s1 : firstIslandShores) {
            for(int[] s2 : secondIslandShores) {
                int bridge = manhattanDistance(s1[0], s1[1], s2[0], s2[1]) > 0 ? manhattanDistance(s1[0], s1[1], s2[0], s2[1]) - 1 : 0 ;
                shortestBridge = Math.min(shortestBridge, bridge);
            }
        }

        return shortestBridge;
    }

    private void dfsConsume(int[][] grid, int r, int c, List<int[]> shores) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;

        if(grid[r][c] == 1) {
            grid[r][c] = -1;

            if(isShore(grid, r, c)) shores.add(new int[]{r, c});

            dfsConsume(grid, r + 1, c, shores);
            dfsConsume(grid, r, c + 1, shores);
            dfsConsume(grid, r - 1, c, shores);
            dfsConsume(grid, r, c - 1, shores);
        }
    }

    private boolean isShore(int[][] grid, int r, int c) {
        for(int[] dir : DIR) {
            int adjacentCellRow = r + dir[0];
            int adjacentCellCol = c + dir[1];

            if(adjacentCellRow < 0 || adjacentCellCol < 0 || adjacentCellRow >= grid.length || adjacentCellCol >= grid[0].length) {
                return true;
            }

            if(grid[adjacentCellRow][adjacentCellCol] == 0) {
                return true;
            }
        }
        return false;
    }

    private int manhattanDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r2 - r1) + Math.abs(c2 - c1);
    }
}
