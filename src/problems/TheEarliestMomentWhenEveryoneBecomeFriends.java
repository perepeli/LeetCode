package problems;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind();

        for(int[] edge : logs) {
            uf.union(edge);
            if(uf.allNodes.size() == n && uf.map.size() == 1) {
                return uf.lastTimestamp;
            }
        }

        return -1;
    }

    private static class UnionFind {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        int lastTimestamp = 0;

        public void union(int[] edge){
            allNodes.add(edge[1]);
            allNodes.add(edge[2]);

            Integer a = find(edge[1]);
            Integer b = find(edge[2]);

            if(a == null && b == null) {
                map.put(edge[1], new HashSet<>());
                map.get(edge[1]).add(edge[2]);
            } else if(a == null) {
                map.get(b).add(edge[1]);
            } else if(b == null) {
                map.get(a).add(edge[2]);
            } else {
                if(!a.equals(b)) {
                    Set<Integer> setA = map.get(a);
                    Set<Integer> setB = map.get(b);

                    if(setA.size() > setB.size()) {
                        setA.addAll(setB);
                        setA.add(b);
                        map.remove(b);
                    } else {
                        setB.addAll(setA);
                        setB.add(a);
                        map.remove(a);
                    }
                } else {
                    return;
                }
            }

            lastTimestamp = edge[0];
        }

        public Integer find(int node) {
            for(var entry : map.entrySet()) {
                if(entry.getKey() == node || entry.getValue().contains(node)) {
                    return entry.getKey();
                }
            }

            return null;
        }
    }
}
