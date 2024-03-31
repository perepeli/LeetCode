package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i : asteroids) {
            if(stack.size() == 0 || (stack.peekLast() < 0 && i < 0) || (stack.peekLast() > 0 && i > 0) || (stack.peekLast() < 0 && i > 0)) {
                stack.addLast(i);
            } else {
                boolean destroyed = false;
                while(stack.size() > 0 && stack.peekLast() > 0) {
                    if(stack.peekLast() < Math.abs(i)) {
                        stack.removeLast();
                    } else if(stack.peekLast() == Math.abs(i)) {
                        stack.removeLast();
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }

                }
                if(!destroyed) stack.add(i);
            }
        }

        int[] res = new int[stack.size()];
        int index = 0;
        for(int i : stack) res[index++] = i;

        return res;
    }
}
