package problems;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int[] prefixZeroes = new int[s.length() - 1];
        int[] suffixOnes = new int[s.length()];

        for(int i = 0; i < prefixZeroes.length; i++) {
            if(i > 0) prefixZeroes[i] = prefixZeroes[i - 1];
            if(s.charAt(i) == '0') prefixZeroes[i]++;
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            if(i < s.length() - 1) suffixOnes[i] = suffixOnes[i + 1];
            if(s.charAt(i) == '1') suffixOnes[i]++;
        }

        int res = 0;

        for(int i = 0; i < prefixZeroes.length; i++) {
            res = Math.max(res, prefixZeroes[i] + suffixOnes[i + 1]);
        }

        return res;
    }
}
