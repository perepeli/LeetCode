package problems;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];

        for(int row = 0; row < res.length; row++) {
            for(int col = 0; col < res[0].length; col++) {

                int sum = 0;

                for(int i = 0; i < mat1[0].length; i++) {
                    sum += (mat1[row][i] * mat2[i][col]);
                }

                res[row][col] = sum;
            }
        }

        return res;
    }
}
