package problems;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0 && visited[i][j] == false) {
                    visitAllTop(matrix, i,j, visited);
                    visitAllBottom(matrix, i,j, visited);
                    visitAllLeft(matrix, i,j, visited);
                    visitAllRight(matrix, i,j, visited);
                }
            }
        }



        // for(int i = 0; i < matrix.length; i++) {
        //     System.out.println(Arrays.toString(matrix[i]));
        // }
    }

    private void visitAllLeft(int[][] arr, int row, int col, boolean[][] visited) {
        if(col < 0) return;
        if(arr[row][col] != 0) visited[row][col] = true;
        arr[row][col] = 0;
        visitAllLeft(arr, row, col-1, visited);
    }
    private void visitAllRight(int[][] arr, int row, int col, boolean[][] visited) {
        if(col > arr[row].length-1) return;
        if(arr[row][col] != 0) visited[row][col] = true;
        arr[row][col] = 0;
        visitAllRight(arr, row, col+1, visited);
    }
    private void visitAllTop(int[][] arr, int row, int col, boolean[][] visited) {
        if(row < 0) return;
        if(arr[row][col] != 0) visited[row][col] = true;
        arr[row][col] = 0;
        visitAllTop(arr, row-1, col, visited);
    }
    private void visitAllBottom(int[][] arr, int row, int col, boolean[][] visited) {
        if(row > arr.length-1) return;
        if(arr[row][col] != 0) visited[row][col] = true;
        arr[row][col] = 0;
        visitAllBottom(arr, row+1, col, visited);
    }
}
