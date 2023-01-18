package problems;

public class CountBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i = 1; i < n+1; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}
