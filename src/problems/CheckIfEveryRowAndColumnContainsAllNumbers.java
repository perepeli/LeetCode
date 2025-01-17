package problems;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int N = matrix.length;
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                int num = matrix[r][c];

                if(num >= 1 && num <= N) {
                    int numIndex = num - 1;
                    rows[r][numIndex]++;
                    cols[c][numIndex]++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(rows[i][j] != 1) {
                    return false;
                }
                if(cols[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
