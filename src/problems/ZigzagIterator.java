package problems;

import problems.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    Deque<Pair<List<Integer>, Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(!v1.isEmpty()) queue.offer(new Pair<>(v1, 0));
        if(!v2.isEmpty()) queue.offer(new Pair<>(v2, 0));
    }

    public int next() {
        if(!queue.isEmpty()) {
            Pair<List<Integer>, Integer> pair = queue.poll();
            if(pair.getValue() + 1 < pair.getKey().size()) queue.offer(new Pair<>(pair.getKey(), pair.getValue() + 1));
            return pair.getKey().get(pair.getValue());
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
