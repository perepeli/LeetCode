package problems;

public class CountTheNumberOfComputerUnlockingPermutations {
    public int countPermutations(int[] complexity) {
        int MOD = (int)1e9 + 7;
        int n = complexity.length;
        int mini = Integer.MAX_VALUE;
        for (int num : complexity) {
            mini = Math.min(mini, num);
        }

        if (complexity[0] != mini) return 0;

        int cnt = 0;
        for (int num : complexity) {
            if (num == mini) cnt++;
            if (cnt > 1) return 0;
        }

        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans = (ans * i) % MOD;
        }

        return (int)ans;
    }
}
