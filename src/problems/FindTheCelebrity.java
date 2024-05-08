package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheCelebrity {

    public int findCelebrity(int n) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {
            int p = deque.removeLast();
            int q = deque.removeLast();

            boolean pKnowsQ = knows(p, q);
            boolean qKnowsP = knows(q, p);

            if(pKnowsQ && qKnowsP || !pKnowsQ && !qKnowsP) {
                continue;
            }

            if(pKnowsQ) {
                deque.addLast(q);
                continue;
            }

            if(qKnowsP) {
                deque.addLast(p);
                continue;
            }
        }

        if(!deque.isEmpty()) {
            int last = deque.removeLast();
            for(int i = 0; i < n; i++) {
                if(!knows(i, last) || last != i && knows(last, i)) return -1;
            }
            return last;
        }
        return -1;
    }

    boolean knows(int a, int b) {
        return false;
    }
}
