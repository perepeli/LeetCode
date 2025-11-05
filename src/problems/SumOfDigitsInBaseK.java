package problems;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        if (n < k)
            return n;
        int ans = 0;
        int div = 0;
        while (n >= k) {
            int rem = n % k;
            ans += rem;
            div = n / k;
            n = div;
        }
        ans += div;
        return ans;
    }
}
