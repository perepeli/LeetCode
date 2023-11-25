package problems;

public class DecodeWays {
    public int numDecodings(String s) {
        return tabulationDP(s);
    }

    private int tabulationDP(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];

        int rightmost = Character.getNumericValue(arr[dp.length - 1]);
        dp[dp.length - 1] =  rightmost == 0 ? 0 : 1;

        if(dp.length == 1) return dp[0];
        if(dp.length > 1) {
            int prevIndex = dp.length - 2;
            int lastIndex = dp.length - 1;
            int prev = Character.getNumericValue(arr[prevIndex]);
            int last = Character.getNumericValue(arr[lastIndex]);

            if(prev == 0) {
                dp[prevIndex] = 0;
            } else if (prev == 1) {
                if(last == 0) dp[prevIndex] = 1;
                else dp[prevIndex] = 2;
            } else if(prev == 2) {
                if(last == 0) dp[prevIndex] = 1;
                else if(last <= 6) dp[prevIndex] = 2;
                else dp[prevIndex] = 1;
            } else {
                dp[prevIndex] = dp[lastIndex];
            }
        }

        for(int i = dp.length - 3; i >= 0; i--) { // we definately have next 2
            int curr = Character.getNumericValue(arr[i]);
            int next = Character.getNumericValue(arr[i + 1]);

            if(curr == 0) {
                dp[i] = 0;
            } else if(curr == 1) {
                if(next == 0) dp[i] = dp[i + 2];
                else dp[i] = dp[i + 1] + dp[i + 2];
            } else if(curr == 2) {
                if(next == 0) dp[i] = dp[i + 2];
                else if(next > 6) dp[i] = dp[i + 1];
                else dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }
}
