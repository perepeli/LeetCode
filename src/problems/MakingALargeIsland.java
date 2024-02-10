package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import problems.util.Pair;

public class MakingALargeIsland {
    int[][] DIR = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int largestIsland(int[][] grid) {
        int N = grid.length;

        int res = 0;

        UnionFind uf = new UnionFind();

        boolean allOnes = true;


        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(grid[r][c] == 1) {
                    Pair<Integer, Integer> curr = new Pair<>(r, c);
                    if(uf.find(curr) == null) {
                        uf.map.put(curr, new HashSet<>());
                        //System.out.println(curr);
                    }
                    for(int i = 0; i < 4; i++) {
                        int newR = r + DIR[i][0];
                        int newC = c + DIR[i][1];

                        if(newR >= 0 && newC >= 0 && newR < N && newC < N && grid[newR][newC] == 1) {
                            uf.unify(curr, new Pair<>(newR, newC));
                        }
                    }

                } else {
                    allOnes = false;
                }
            }
        }

        if(allOnes) return N * N;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(grid[r][c] == 0) {
                    Pair<Integer, Integer> curr = new Pair<>(r, c);
                    Set<Pair<Integer, Integer>> adjSet = new HashSet<>();
                    for(int i = 0; i < 4; i++) {
                        int newR = r + DIR[i][0];
                        int newC = c + DIR[i][1];

                        if(newR >= 0 && newC >= 0 && newR < N && newC < N && grid[newR][newC] == 1) {
                            Pair<Integer, Integer> toFind = new Pair<>(newR, newC);
                            Pair<Integer, Integer> found = uf.find(toFind);
                            if(found != null) adjSet.add(found);
                        }
                    }
                    int tempCount = 1;
                    for(var p : adjSet) {
                        tempCount += uf.map.get(p).size() + 1;
                    }
                    res = Math.max(res, tempCount);
                }
            }
        }

        return res;
    }

    static class UnionFind {
        public Map<Pair<Integer, Integer>, Set<Pair<Integer, Integer>>> map = new HashMap<>();

        public Pair<Integer, Integer> find(Pair<Integer, Integer> pair) {
            for(var e : map.entrySet()) {
                if(e.getKey().equals(pair) || e.getValue().contains(pair)) return e.getKey();
            }
            return null;
        }
        public void unify(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            Pair<Integer, Integer> found1 = find(p1);
            Pair<Integer, Integer> found2 = find(p2);

            if(found1 == null && found2 == null) {
                Set<Pair<Integer, Integer>> p2Set = new HashSet<>();
                p2Set.add(p2);
                map.put(p1, p2Set);
            } else if(found1 == null) {
                map.get(found2).add(p1);
            } else if(found2 == null) {
                map.get(found1).add(p2);
            } else {
                if(found1 == found2) return;
                if(map.get(found1).size() > map.get(found2).size()) {
                    map.get(found1).addAll(map.get(found2));
                    map.get(found1).add(found2);
                    map.remove(found2);
                } else {
                    map.get(found2).addAll(map.get(found1));
                    map.get(found2).add(found1);
                    map.remove(found1);
                }
            }
        }
    }
}
