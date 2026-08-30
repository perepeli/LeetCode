package problems;

import java.util.List;
import java.util.Map;

public class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String, int[]> DIR = Map.of(
                "UP", new int[]{-1,0},
                "DOWN", new int[]{1,0},
                "LEFT", new int[]{0,-1},
                "RIGHT", new int[]{0,1}
        );

        int i = 0;
        int j = 0;

        for(String command : commands) {
            int[] next = DIR.get(command);
            i += next[0];
            j += next[1];
        }

        return (i * n) + j;
    }
}
