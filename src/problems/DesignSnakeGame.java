package problems;

import problems.util.Pair;

import java.util.*;

public class DesignSnakeGame {
    private static Map<String, int[]> DIR = Map.of(
            "U", new int[]{-1, 0},
            "D", new int[]{1, 0},
            "L", new int[]{0, -1},
            "R", new int[]{0, 1}
    );

    Deque<Pair<Integer, Integer>> snakeBody;
    Set<Pair<Integer, Integer>> snakeLocations;
    boolean isGameOver = false;
    int score = 0;
    int[][] food;
    int foodIndex;
    int row;
    int col;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.food = food;
        foodIndex = 0;
        snakeBody = new LinkedList<>();
        snakeBody.addLast(new Pair<>(0, 0));
        snakeLocations = new HashSet<>();
        snakeLocations.add(new Pair<>(0, 0));
        col = width;
        row = height;
    }

    public int move(String direction) {
        if(isGameOver) return -1;

        Pair<Integer, Integer> head = snakeBody.peekLast();
        int[] offset = DIR.get(direction);
        Pair<Integer, Integer> newLocation = new Pair<>(head.getKey() + offset[0], head.getValue() + offset[1]);

        if(
                newLocation.getKey() < 0 ||
                        newLocation.getValue() < 0 ||
                        newLocation.getKey() >= row ||
                        newLocation.getValue() >= col
        ) {
            isGameOver = true;
            return -1;
        }

        if(foodIndex < food.length && newLocation.getKey() == food[foodIndex][0] && newLocation.getValue() == food[foodIndex][1]) {
            foodIndex++;
            score++;
        } else {
            snakeLocations.remove(snakeBody.removeFirst());
        }

        if(snakeLocations.contains(newLocation)) {
            isGameOver = true;
            return -1;
        }

        snakeBody.addLast(newLocation);
        snakeLocations.add(newLocation);

        return score;
    }
}
