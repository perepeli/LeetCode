package problems;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        //return recursive(text1.toCharArray(), text2.toCharArray(), 0, 0);

        //return recursive(text1.toCharArray(), text2.toCharArray(), 0, 0, new HashMap<>());

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return recursive(text1.toCharArray(), text2.toCharArray(), 0, 0, dp);
    }

    private int recursive(char[] arr1, char[] arr2, int leftIndex, int rightIndex) { // recursive top-down (brute-force) O(2^n) time
        if(leftIndex > arr1.length - 1 || rightIndex > arr2.length - 1) return 0;
        if(arr1[leftIndex] == arr2[rightIndex]) return 1 + recursive(arr1, arr2, leftIndex + 1, rightIndex + 1);
        return Math.max(recursive(arr1, arr2, leftIndex + 1, rightIndex), recursive(arr1, arr2, leftIndex, rightIndex + 1));
    }

    private int recursive(char[] arr1, char[] arr2, int leftIndex, int rightIndex, Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> map) { // recursive top-down O(m*n) time using dp map
        AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(leftIndex, rightIndex);
        if(map.containsKey(key)) {
            return map.get(key);
        } else if(leftIndex > arr1.length - 1 || rightIndex > arr2.length - 1) {
            map.put(key, 0);
            return map.get(key);
        } else if(arr1[leftIndex] == arr2[rightIndex]) {
            map.put(key, 1 + recursive(arr1, arr2, leftIndex + 1, rightIndex + 1, map));
            return map.get(key);
        } else {
            map.put(key, Math.max(recursive(arr1, arr2, leftIndex + 1, rightIndex, map), recursive(arr1, arr2, leftIndex, rightIndex + 1, map)));
            return map.get(key);
        }
    }

    private int recursive(char[] arr1, char[] arr2, int leftIndex, int rightIndex, int[][] dp) {  // recursive top-down O(m*n) time using dp array
        if(leftIndex == arr1.length || rightIndex == arr2.length) {
            dp[leftIndex][rightIndex] = 0;
            return dp[leftIndex][rightIndex];
        } else if(dp[leftIndex][rightIndex] != -1) {
            return dp[leftIndex][rightIndex];
        } else if(arr1[leftIndex] == arr2[rightIndex]) {
            dp[leftIndex][rightIndex] = 1 + recursive(arr1, arr2, leftIndex + 1, rightIndex + 1, dp);
            return dp[leftIndex][rightIndex];
        } else {
            dp[leftIndex][rightIndex] = Math.max(recursive(arr1, arr2, leftIndex + 1, rightIndex, dp), recursive(arr1, arr2, leftIndex, rightIndex + 1, dp));
            return dp[leftIndex][rightIndex];
        }
    }
}
