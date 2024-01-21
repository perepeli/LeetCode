package problems;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long max = Long.MIN_VALUE;

        for(int i = questions.length - 1; i >= 0; i--) {
            if(i == questions.length - 1) {
                dp[i] = questions[i][0];
            } else {
                long skipValue = dp[i + 1];
                int nextAllowed = i + questions[i][1] + 1;
                long solveValue = questions[i][0] + (nextAllowed < dp.length ? dp[nextAllowed] : 0);
                dp[i]= Math.max(skipValue, solveValue);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
