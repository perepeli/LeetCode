package problems;

import problems.listnode.Pair;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}}, 5, 3));
        System.out.println(networkDelayTime(new int[][]{{1,2,2}, {1,3,4}, {2,4,7}, {2,3,1}, {3,5,3}, {4,6,1}, {5,6,5}, {5,4,2} }, 6, 1));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] minDelays = new int[n];
        Arrays.fill(minDelays, Integer.MAX_VALUE);

        Map<Integer, List<Pair<Integer, Integer>>> allDirections = new HashMap<>();
        for (int[] e : times) {
            Integer from = e[0];
            Integer to = e[1];
            Integer delay = e[2];
            if(!allDirections.containsKey(from)) allDirections.put(from, new ArrayList<>());
            allDirections.get(from).add(new Pair<>(to, delay));
        }
        PriorityQueue<Pair<Integer, Integer>> nodeDelays = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        nodeDelays.offer(new Pair<>(k, 0));
        minDelays[k - 1] = 0;

        while(!nodeDelays.isEmpty()) {
            Pair<Integer, Integer> nodeDelay = nodeDelays.poll();
            Integer node = nodeDelay.getKey();
            Integer delay = nodeDelay.getValue();

            if(allDirections.containsKey(node)) {
                for (Pair<Integer, Integer> direction : allDirections.get(node)) {
                    Integer toNode = direction.getKey();
                    Integer toNodeDelay = direction.getValue();
                    int bestTime = Math.min(delay + toNodeDelay, minDelays[toNode - 1]);
                    if (bestTime < minDelays[toNode - 1]) {
                        minDelays[toNode - 1] = bestTime;
                        nodeDelays.offer(new Pair<>(toNode, bestTime));
                    }
                }
            }

        }

        int maxDelay = Integer.MIN_VALUE;

        for (int i : minDelays) {
            if(i == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(i, maxDelay);
        }

        return maxDelay;
    }
}
