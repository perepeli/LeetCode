package problems;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for(int row = 0; row < length; row++) {
            for(int col = row; col < length; col++) {
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }

        for(int row = 0; row < length; row++) {
            for(int col = 0; col < length/2; col++) {
                int temp = matrix[row][length-col-1];
                matrix[row][length-col-1] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }
}
