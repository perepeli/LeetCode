package problems;

import java.util.*;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.unify(1, 2);
        uf.unify(2, 1);
        uf.unify(2, 3);
        uf.unify(1,6);

        uf.unify(7,8);
        uf.unify(8,1);
        uf.unify(1,2);

        //uf.map.forEach((k, v) -> System.out.println(k + " : " + v));


        System.out.println(countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
    }

    public static long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind();
        for(int[] edge : edges) {
            uf.unify(edge[0], edge[1]);
        }

        uf.map.forEach((k, v) -> System.out.println(k + " : " + v));

        Set<Integer> allMapped = new HashSet<>();
        Set<Integer> allSingle = new HashSet<>();

        for(Map.Entry<Integer, Set<Integer>> entry : uf.map.entrySet()) {
            allMapped.add(entry.getKey());
            allMapped.addAll(entry.getValue());
        }

        for(int i = 0; i < n; i++) {
            allSingle.add(i);
        }

        allSingle.removeAll(allMapped);

        ArrayList<Integer> list = new ArrayList<>();

        allSingle.forEach(ignored -> list.add(1));

        Map<Integer, Set<Integer>> m = uf.map;
        m.forEach((k, v) -> list.add(1 + v.size()));

        System.out.println(list);

        int result = 0;

        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                result += (list.get(i) * list.get(j));
            }
        }

        return result;
    }

    static class UnionFind {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public void unify(int p, int q) {
            Map.Entry<Integer, Set<Integer>> P = find(p);
            Map.Entry<Integer, Set<Integer>> Q = find(q);

            if(P == null && Q == null) {
                Set<Integer> valueSet = new HashSet<>();
                valueSet.add(q);
                map.put(p, valueSet);
                return;
            }

            if(P == Q) return;

            if(Q == null && (P.getKey() == p || P.getValue().contains(p))) {
                P.getValue().add(q);
                return;
            }

            if(P == null && (Q.getKey() == q || Q.getValue().contains(q))) {
                Q.getValue().add(p);
                return;
            }

                Set<Integer> newValue = new HashSet();
                newValue.addAll(P.getValue());
                newValue.addAll(Q.getValue());
                newValue.add(Q.getKey());

                map.remove(P.getKey());
                map.remove(Q.getKey());

                map.put(P.getKey(), newValue);
        }

        public Map.Entry<Integer, Set<Integer>> find(int e) {
            for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if(entry.getKey().equals(e) || entry.getValue().contains(e)) return entry;
            }
            return null;
        }
    }
}
