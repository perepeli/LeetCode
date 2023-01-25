package problems;

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != (m * n)) return new int[0][0];

        int[][] arr = new int[m][n];

        int row = 0;
        int col = 0;

        for(int i = 0; i < original.length; i++) {
            arr[row][col] = original[i];

            if(col == (n-1)) {
                col = 0;
                row++;
            } else {
                col++;
            }
        }

        return arr;
    }
}
