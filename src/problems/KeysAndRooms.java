package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int visitCount = 0;

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int room = queue.poll();

            if(visited[room]) continue;
            visited[room] = true;
            visitCount++;

            for(int key : rooms.get(room)) {
                if(!visited[key]) queue.offer(key);
            }
        }

        return visitCount == rooms.size();
    }
}
