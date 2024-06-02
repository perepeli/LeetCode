package problems;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {
    Deque<Integer> deque;

    public NumberOfRecentCalls() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        while(deque.size() > 0 && t - deque.peekFirst() > 3000) deque.removeFirst();
        deque.add(t);
        return deque.size();
    }
}
