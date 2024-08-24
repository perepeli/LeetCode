package problems;


import java.util.List;

interface BinaryMatrix {
     public int get(int row, int col);
     public List<Integer> dimensions();
}

public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);

        int res = -1;

        for(int i = 0; i < row; i++) {
            if(binaryMatrix.get(i, col - 1) == 0) continue;

            int left = 0;
            int right = col - 1;

            while(left < right) {
                int mid = left + (right - left) / 2;

                if(binaryMatrix.get(i, mid) > 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if(binaryMatrix.get(i, left) == 1) {
                if(res == -1) res = left;
                else res = Math.min(res, left);
            }
        }

        return res;
    }
}
