package problems;

import problems.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    private final int[][] DIR = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int index = 0;

        Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
        for(int[] i : obstacles) {
            obstacleSet.add(new Pair(i[0], i[1]));
        }

        int x = 0;
        int y = 0;

        for(int i = 0; i < commands.length; i++) {
            int command = commands[i];

            if(command == -1) {
                index = (index + 1) % DIR.length;
            } else if(command == -2) {
                index = (index - 1 + DIR.length) % DIR.length;
            } else {
                int tempX = x;
                int tempY = y;

                for(int j = 1; j <= command; j++) {
                    int nextX = x + j * DIR[index][0];
                    int nextY = y + j * DIR[index][1];

                    if(!obstacleSet.contains(new Pair<>(nextX, nextY))) {
                        tempX = nextX;
                        tempY = nextY;
                    } else {
                        break;
                    }
                }

                max = Math.max(max, tempX * tempX + tempY * tempY);

                x = tempX;
                y = tempY;
            }
        }

        return max;
    }
}
