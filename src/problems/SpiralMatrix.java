package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();

        int direction = 0; // 0:=right, 1:=borttom, 2:=left, 3:=top

        while(left <= right && top <= bottom) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) { // left to right
                    res.add(matrix[top][i]);
                }
                top++;
                direction = (direction + 1) % 4;
                continue;
            }
            if(direction == 1) {
                for(int i = top; i <= bottom; i++) { // top to bottom
                    res.add(matrix[i][right]);
                }
                right--;
                direction = (direction + 1) % 4;
                continue;
            }
            if(direction == 2) {
                for(int i = right; i >= left; i--) { // right to left
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                direction = (direction + 1) % 4;
                continue;
            }
            if(direction == 3) {
                for(int i = bottom; i >= top; i--) { // bottom to top
                    res.add(matrix[i][left]);
                }
                left++;
                direction = (direction + 1) % 4;
                continue;
            }

        }

        return res;
    }
}
