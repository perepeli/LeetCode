package problems;

import java.util.*;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);

            adjList.putIfAbsent(parent, new HashSet<>());
            adjList.get(parent).add(child);
        }

        List<Integer> res = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);

        while(!queue.isEmpty()) {
            int process = queue.poll();
            res.add(process);
            if(adjList.containsKey(process))
                for(int child : adjList.get(process)) queue.offer(child);
        }

        return res;
    }
}
