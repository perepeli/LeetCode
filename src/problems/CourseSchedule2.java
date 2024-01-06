package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            indegree[course]++;
            adj.get(prerequisite).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        List<Integer> res = new ArrayList<>();

        int visitedNodes = 0;

        while(!queue.isEmpty()) {
            int prerequisite = queue.poll();
            visitedNodes++;
            res.add(prerequisite);

            for(int course : adj.get(prerequisite)) {
                indegree[course]--;
                if(indegree[course] == 0) queue.add(course);
            }
        }
        for(int i : indegree) {
            if(i != 0) return new int[0];
        }
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
