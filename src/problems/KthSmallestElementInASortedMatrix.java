package problems;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((p1, p2) -> p1.getKey() - p2.getKey());

        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            pq.offer(new Pair<>(row[0], new Pair<>(i, 0)));
        }


        while(k > 1) {
            Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
            int row = p.getValue().getKey();
            int col = p.getValue().getValue();

            if(col < matrix[0].length - 1) {
                pq.offer(new Pair<>(matrix[row][col + 1], new Pair<>(row, col + 1)));
            }
            k--;
        }
        return pq.poll().getKey();
    }
}
