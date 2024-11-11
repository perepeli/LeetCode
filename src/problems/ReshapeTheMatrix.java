package problems;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) return mat;

        int[][] res = new int[r][c];

        int R = 0;
        int C = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                res[R][C++] = mat[i][j];

                if(C == c) {
                    C = 0;
                    R++;
                }
            }
        }

        return res;
    }
}
