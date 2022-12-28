package problems;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,1,1},{1,1,0}, {1,0,1}};
        int[][] arr2 = new int[][]{{0,0,0},{0,0,0}};
        floodFill(arr1, 1, 1, 2);

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        recursive(image, sr, sc, image.length-1, image[0].length-1, image[sr][sc], color);
        return image;
    }

    private static void recursive(int[][] image, int sr, int sc, int rows, int columns, int target, int color) {
        if(sr < 0 || sr > rows || sc < 0 || sc > columns) return;
        if(image[sr][sc] == target) {
            image[sr][sc] = color;
        } else {
            return;
        }
        //up
        recursive(image, sr-1, sc, rows, columns, target, color);
        //left
        recursive(image, sr, sc-1, rows, columns, target, color);
        //down
        recursive(image, sr+1, sc, rows, columns, target, color);
        //right
        recursive(image, sr, sc+1, rows, columns, target, color);
    }
}
