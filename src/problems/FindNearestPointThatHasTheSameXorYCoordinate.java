package problems;

public class FindNearestPointThatHasTheSameXorYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int indexOfSmallest = -1;
        int smallestSoFar = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            if((points[i][0] == x) && (points[i][1] == y)) {
                indexOfSmallest = i;
                return indexOfSmallest;
            } else if ((points[i][0] == x) || (points[i][1] == y)) {
                int tempSmallest = Math.min(smallestSoFar, Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]));
                if(!(smallestSoFar <= tempSmallest)) {
                    smallestSoFar = tempSmallest;
                    indexOfSmallest = i;
                }
            }
        }
        return indexOfSmallest;
    }
}
