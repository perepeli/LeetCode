package problems;

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int max = 0;

        for(int i = 0; i < mat.length; i++) {
            int tempOnes = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    tempOnes++;
                }
            }
            if(tempOnes > max) {
                index = i;
                max = tempOnes;
            }
        }

        return new int[]{index, max};
    }
}
