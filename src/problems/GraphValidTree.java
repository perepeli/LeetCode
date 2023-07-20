package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0 && n == 1) return true;

        UnionFind uf = new UnionFind();

        for(int[] edge : edges) {
            boolean r = uf.unify(edge[0], edge[1]);
            if(!r) return false;
        }

        if((n - uf.numEdges()) > 0) return false;

        return uf.numComponents() == 1;
    }

    class UnionFind {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> edges = new HashSet<>();

        public boolean unify(int p, int q) {
            Map.Entry<Integer, Set<Integer>> P = find(p);
            Map.Entry<Integer, Set<Integer>> Q = find(q);

            if(P == null && Q == null) {
                Set<Integer> setValue = new HashSet<>();
                setValue.add(q);
                map.put(p, setValue);
                edges.add(p);
                edges.add(q);
                return true;
            } else if(P == Q) {
                return false;
            } else if(Q == null && P != null) {
                P.getValue().add(q);
                edges.add(p);
                edges.add(q);
                return true;
            } else if(P == null && Q != null) {
                Q.getValue().add(p);
                edges.add(p);
                edges.add(q);
                return true;
            } else {
                if(P.getValue().size() > Q.getValue().size()) {
                    P.getValue().add(Q.getKey());
                    P.getValue().addAll(Q.getValue());
                    map.remove(Q.getKey());
                } else {
                    Q.getValue().add(P.getKey());
                    Q.getValue().addAll(P.getValue());
                    map.remove(P.getKey());
                }
                edges.add(p);
                edges.add(q);
                return true;
            }

        }

        public Map.Entry<Integer, Set<Integer>> find(int e) {
            for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if(entry.getKey() == e || entry.getValue().contains(e)) return entry;
            }

            return null;
        }

        public int numComponents() {
            return map.entrySet().size();
        }

        public int numEdges() {
            return edges.size();
        }
    }
}

