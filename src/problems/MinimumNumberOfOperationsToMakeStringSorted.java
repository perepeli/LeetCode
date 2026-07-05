package problems;

public class MinimumNumberOfOperationsToMakeStringSorted {
    long[] inv = new long[3001];
    long[] fact = new long[3001];
    long[] invfact = new long[3001];
    int M = (int)1e9+7;

    public int makeStringSorted(String s) {
        int[] count = new int[26];
        fact[0]=invfact[0]=fact[1]=invfact[1]=inv[1]=1;

        for (int i = 2; i <= 3000; i++){
            inv[i] = M-M/i*inv[M%i]%M;
            fact[i] = fact[i-1]*i%M;
            invfact[i] = invfact[i-1]*inv[i]%M;
        }

        long ans = 0;

        for (int i = s.length()-1; i >= 0; i--){
            int k = s.charAt(i) - 'a', ttl = 0;
            count[k]++;
            for (int j = 0; j < k; j++){
                ttl += count[j];
            }
            long cur = ttl * fact[s.length()-1-i] % M;
            for (int j = 0; j < 26; j++){
                cur *= invfact[count[j]];
                cur %= M;
            }
            ans += cur;
            ans %= M;
        }

        return (int)ans;
    }
}
