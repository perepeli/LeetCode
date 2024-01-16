package problems;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int r = 1; r < dp.length; r++) {
            dp[r][0] = dp[r - 1][0] + 1;
        }

        for(int c = 1; c < dp[0].length; c++) {
            dp[0][c] = dp[0][c - 1] + 1;
        }

        for(int r = 1; r < dp.length; r++) {
            for(int c = 1; c < dp[0].length; c++) {
                int min = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                if(word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = min + 1;
                }
            }
        }
        //for(int[] r : dp) System.out.println(Arrays.toString(r));

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
