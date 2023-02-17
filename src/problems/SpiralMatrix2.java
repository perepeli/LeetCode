package problems;

import java.util.Arrays;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        populateMatrix(matrix, n);

        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix;
    }

    private void populateMatrix(int[][] matrix, int n) {

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;


        int direction = 0; // 0 -> left, 1 -> down, 2 -> left, 3 -> up
        int currentNumber = 1;

        while(left <= right && top <= bottom) {
            if(direction == 0) { // from left to right
                for(int i = left; i <= right; i++) {
                    matrix[top][i] = currentNumber;
                    currentNumber++;
                }
                top++;
            }

            if(direction == 1) { // from top to bottom

                for(int i = top; i <= bottom; i++) {
                    matrix[i][right] = currentNumber;
                    currentNumber++;
                }
                right--;
            }

            if(direction == 2) { // from right to left
                for(int i = right; i >= left; i--) {
                    matrix[bottom][i] = currentNumber;
                    currentNumber++;
                }
                bottom--;
            }

            if(direction == 3) { // from bottom to top
                for(int i = bottom; i >= top; i--) {
                    matrix[i][left] = currentNumber;
                    currentNumber++;
                }
                left++;
            }

            direction = (direction + 1) % 4;
        }
    }
}
