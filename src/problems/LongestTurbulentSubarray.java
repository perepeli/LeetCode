package problems;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 0) return 0;

        int[] dp = new int[arr.length];

        int max = 1;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(i == arr.length - 1) {
                dp[i] = 1;
            } else if(i == arr.length - 2) {
                if(arr[i] != arr[i + 1]) dp[i] = 2;
                else dp[i] = 1;
            } else {
                if(arr[i] > arr[i+1] && arr[i+1] < arr[i+2]) dp[i] = 1 + dp[i+1];
                else if(arr[i] < arr[i+1] && arr[i+1] > arr[i+2]) dp[i] = 1 + dp[i+1];
                else if(arr[i] > arr[i+1] || arr[i] < arr[i+1]) dp[i] = 2;
                else dp[i] = 1;
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
