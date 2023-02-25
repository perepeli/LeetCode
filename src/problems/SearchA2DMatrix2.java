package problems;

public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int row = 0; row < matrix.length && matrix[row][0] <= target; row++) {
            if (binarySearch(matrix[row], target, 0, matrix[0].length-1)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target, int left, int right) {

        while(left <= right) {
            int middleIndex = left + (right - left) / 2;

            if(arr[middleIndex] == target) return true;

            if(target > arr[middleIndex]) left = middleIndex + 1;
            else right = middleIndex - 1;
        }
        return false;
    }
}
