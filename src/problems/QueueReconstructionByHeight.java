package problems;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0];
        });


        int[][] res = new int[people.length][2];

        for(int i = 0; i < people.length; i++) {
            if(i == 0) res[i] = people[i];
            else {
                int[] pair = people[i];
                if(pair[0] == res[i - 1][0]) res[i] = pair;
                else {
                    for(int j = i; j > pair[1]; j--) {
                        res[j] = res[j - 1];
                    }
                    res[pair[1]] = pair;
                }
            }
        }

        return res;
    }
}
