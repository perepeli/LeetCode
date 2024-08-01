package problems;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;

        boolean[][] visited = new boolean[isConnected.length][isConnected[0].length];

        for(int i = 0; i < isConnected[0].length; i++) {
            if(!visited[i][0]) {
                visit(isConnected, i, visited);
                res++;
            }
        }

        return res;
    }

    void visit(int[][] matrix, int i, boolean[][] visited) {
        if(visited[i][0]) return;

        for(int col = 0; col < matrix[i].length; col++) {
            visited[i][col] = true;
            if(matrix[i][col] == 1) {
                visit(matrix, col, visited);
            }
        }
    }
}
