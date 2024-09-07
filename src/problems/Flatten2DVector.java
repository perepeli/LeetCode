package problems;

public class Flatten2DVector {
    int[][] vec;
    int rowIndex;
    int colIndex;

    public Flatten2DVector(int[][] vec) {
        this.vec = vec;
        rowIndex = 0;
        colIndex = 0;
    }

    public int next() {
        int cur = vec[rowIndex][colIndex];

        if(colIndex + 1 == vec[rowIndex].length) {
            colIndex = 0;
            rowIndex++;
        } else {
            colIndex++;
        }

        return cur;
    }

    public boolean hasNext() {
        advanceInvalid();
        return rowIndex < vec.length;
    }

    private void advanceInvalid() {
        while(rowIndex < vec.length && vec[rowIndex].length == 0) {
            rowIndex++;
        }
    }
}
