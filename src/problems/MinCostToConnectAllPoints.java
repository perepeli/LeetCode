package problems;

import problems.util.Pair;

import java.util.*;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        List<Pair<Point, Pair<Point, Integer>>> list = new ArrayList<>();

        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int[] first = points[i];
                int[] second = points[j];

                int distance = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);

                Point key = new Point(first[0], first[1]);
                Point value = new Point(second[0], second[1]);

                list.add(new Pair<>(key, new Pair<>(value, distance)));
            }
        }

        Collections.sort(list, Comparator.comparingInt(p -> p.getValue().getValue()));
        int result = 0;
        DisjointSet uf = new DisjointSet();

        for(Pair<Point, Pair<Point, Integer>> e: list) {
            Point from = e.getKey();
            Point to = e.getValue().getKey();
            int distance = e.getValue().getValue();

            boolean isPartOfMST = uf.unify(from, to);

            if(isPartOfMST) result += distance;
        }
        return result;
    }

    static class DisjointSet {
        public Map<Point, Set<Point>> map = new HashMap();

        public boolean unify(Point p, Point q) {
            Map.Entry<Point, Set<Point>> P = find(p);
            Map.Entry<Point, Set<Point>> Q = find(q);

            if(P == null && Q == null) {
                Set<Point> valueSet = new HashSet<>();
                valueSet.add(q);
                map.put(p, valueSet);
                return true;
            }

            if(P == Q) return false;

            if(Q == null && (P.getKey().equals(p) || P.getValue().contains(p))) {
                P.getValue().add(q);
                return true;
            }

            if(P == null && (Q.getKey().equals(q) || Q.getValue().contains(q))) {
                Q.getValue().add(p);
                return true;
            }
            Set<Point> newValue = new HashSet();
            newValue.addAll(P.getValue());
            newValue.addAll(Q.getValue());
            newValue.add(Q.getKey());

            map.remove(P.getKey());
            map.remove(Q.getKey());

            map.put(P.getKey(), newValue);
            return true;
        }

        public Map.Entry<Point, Set<Point>> find(Point e) {
            for(Map.Entry<Point, Set<Point>> entry : map.entrySet()) {
                if(entry.getKey().equals(e) || entry.getValue().contains(e)) return entry;
            }
            return null;
        }
    }

    static class Point extends Pair<Integer, Integer> {
        public Point(Integer key, Integer value) {
            super(key, value);
        }
    }
}
