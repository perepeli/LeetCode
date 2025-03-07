package problems;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private Deque<Integer> s1;
        private Deque<Integer> s2;

        public MyQueue() {
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        public void push(int x) {
            while(!s1.isEmpty()) {
                s2.addLast(s1.removeLast());
            }
            s1.addLast(x);
            while(!s2.isEmpty()) {
                s1.addLast(s2.removeLast());
            }
        }

        public int pop() {
            return s1.removeLast();
        }

        public int peek() {
            return s1.peekLast();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }
}
