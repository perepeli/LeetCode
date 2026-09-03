package problems;

public class NearestAvailableDrone {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int minDroneIndex = -1;

        for(int i = 0; i < drones.length; i++) {

            int distanceX = Math.abs(target[0] - drones[i][0]);
            int distanceY = Math.abs(target[1] - drones[i][1]);
            int manhattanDistance = distanceX + distanceY;

            if(manhattanDistance <= drones[i][2]) {
                if(manhattanDistance < minDistance) {
                    minDistance = manhattanDistance;
                    minDroneIndex = i;
                }
            }
        }

        return minDroneIndex;
    }
}
