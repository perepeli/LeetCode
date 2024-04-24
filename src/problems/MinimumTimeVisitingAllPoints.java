package problems;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length < 2) return 0;

        int res = 0;

        for(int i = 1; i < points.length; i++) {
            int[] first = points[i - 1];
            int[] second = points[i];

            int x1 = first[0];
            int y1 = first[1];

            int x2 = second[0];
            int y2 = second[1];

            int distX = Math.abs(x2 - x1);
            int distY = Math.abs(y2 - y1);

            int smallest = Math.min(distX, distY);

            if(smallest > 0) {
                res += smallest;
                distX -= smallest;
                distY -= smallest;
            }

            res += distX;
            res += distY;
        }

        return res;
    }
}
