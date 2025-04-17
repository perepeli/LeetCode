package problems;

public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int M = boxGrid.length;
        int N = boxGrid[0].length;

        char[][] res = new char[N][M];

        for(char[] arr : boxGrid) {
            int left = 0;
            for(int right = 0; right < arr.length; right++) {
                char c = arr[right];

                if(c == '*') {
                    left = right + 1;
                } else if(c == '.') {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                res[j][i] = boxGrid[i][j];
            }
        }

        for(int i = 0; i < N; i++) {
            char[] arr = res[i];
            for(int j = 0; j < M / 2; j++) {
                char temp = arr[j];
                arr[j] = arr[M - 1 - j];
                arr[M - 1 - j] = temp;
            }
        }

        return res;
    }
}
