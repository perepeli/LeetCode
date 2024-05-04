package problems;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobs = new int[profit.length][2];
        for(int i = 0; i < profit.length; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        Arrays.sort(worker);

        int res = 0;
        int i = 0;
        int best = 0;
        for(int skill : worker) {
            while(i < difficulty.length && skill >= jobs[i][0])
                best = Math.max(best, jobs[i++][1]);
            res += best;
        }
        return res;
    }
}
