package problems;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        int right = mat[0].length - 1;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(j == right) {
                    sum += mat[i][j];
                }
                if(i == j) {

                    sum += mat[i][j];
                }
            }
            right--;
        }

        if(mat.length % 2 != 0) sum -= mat[(mat[0].length-1) / 2][(mat.length-1) / 2];


        return sum;
    }
}
