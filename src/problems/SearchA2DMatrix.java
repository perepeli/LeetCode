package problems;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int right = M * N - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid / N][mid % N] >= target) right = mid;
            else left = mid + 1;
        }

        if(matrix[left / N][left % N] == target) return true;
        return false;
    }
}
