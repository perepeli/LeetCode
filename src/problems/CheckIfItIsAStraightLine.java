package problems;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }

        int[] p0 = coordinates[0];
        int[] p1 = coordinates[1];

        int dx = p1[0] - p0[0];
        int dy = p1[1] - p0[1];

        for (int i = 2; i < coordinates.length; i++) {

            int[] p = coordinates[i];

            int dx2 = p[0] - p0[0];
            int dy2 = p[1] - p0[1];

            int cross = dx * dy2 - dy * dx2;

            if (cross != 0) {
                return false;
            }
        }

        return true;
    }
}
