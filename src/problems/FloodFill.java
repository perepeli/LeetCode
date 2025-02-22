package problems;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return image;
        if(image[sr][sc] == color) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int originalColor) {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if(image[r][c] != originalColor) return;
        image[r][c] = color;
        dfs(image, r + 1, c, color, originalColor);
        dfs(image, r - 1, c, color, originalColor);
        dfs(image, r, c + 1, color, originalColor);
        dfs(image, r, c - 1, color, originalColor);
    }
}
