package problems;

import problems.util.Pair;

import java.util.*;


public class DesignSnakeGame {
    int width, height;
    int[][] food;
    int score;
    LinkedList<Node> snake;

    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isEqual(Node node) {
            return this.row == node.row && this.col == node.col;
        }
    }

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        snake = new LinkedList<>();
        snake.add(new Node(0, 0));
    }

    public int move(String direction) {
        Node head = snake.peekFirst();
        Node next = new Node(head.row, head.col);

        switch (direction) {
            case "U":
                next.row--;
                break;
            case "D":
                next.row++;
                break;
            case "L":
                next.col--;
                break;
            case "R":
                next.col++;
        }

        if (next.row < 0 || next.row >= height || next.col < 0 || next.col >= width) {
            return -1;
        }

        for (int i = 0; i < snake.size() - 1; i++) {
            if (next.isEqual(snake.get(i))) {
                return -1;
            }
        }

        if (score < food.length && next.row == food[score][0] && next.col == food[score][1]) {
            score++;
            snake.addFirst(next);
        } else {
            snake.addFirst(next);
            snake.removeLast();
        }
        return score;
    }
}
