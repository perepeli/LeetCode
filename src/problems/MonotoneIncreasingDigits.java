package problems;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] S = String.valueOf(n).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] > S[i]) S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';

        return Integer.parseInt(String.valueOf(S));
    }
}
