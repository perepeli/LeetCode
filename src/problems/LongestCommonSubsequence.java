package problems;

import problems.util.Pair;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        //return recursive(text1.toCharArray(), text2.toCharArray(), 0, 0);
        return tabulationDP(text1.toCharArray(), text2.toCharArray());
    }

    private static int recursive(char[] t1, char[] t2, int i, int j) {
        if (i == t1.length || j == t2.length) {
            return 0;
        } else if (t1[i] == t2[j]) {
            return 1 + recursive(t1, t2, i + 1, j + 1);
        } else {
            return Math.max(recursive(t1, t2, i, j + 1), recursive(t1, t2, i + 1, j));
        }
    }

    private static int tabulationDP(char[] t1, char[] t2) {
        int[][] dp = new int[t1.length+1][t2.length+1];

        for(int i = t1.length-1; i >= 0; i--) {
            for(int j = t2.length-1; j >= 0; j--) {
                if(t1[i] == t2[j]) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
