package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for(int[] prerequisite : prerequisites) {
            int dependee = prerequisite[0];
            int dependency = prerequisite[1];

            inDegree[dependee]++;
            adjList.get(dependency).add(dependee);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int dependency = queue.poll();
            for(int dependee : adjList.get(dependency)) {
                inDegree[dependee]--;
                if(inDegree[dependee] == 0) {
                    queue.offer(dependee);
                }
            }
            count++;
        }


        return count == numCourses;
    }
}
