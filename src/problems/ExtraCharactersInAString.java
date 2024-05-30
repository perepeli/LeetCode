package problems;

import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersInAString {
    TrieNode root;
    Integer[] memo;

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        root = buildTrie(dictionary);
        memo = new Integer[n + 1];
        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if(start == n) return 0;
        if(memo[start] != null) return memo[start];

        TrieNode node = root;

        int res = dp(start + 1, n, s) + 1;

        for(int end = start; end < n; end++) {
            char c = s.charAt(end);
            if(!node.children.containsKey(c)) break;
            node = node.children.get(c);
            if(node.isWord) res = Math.min(res, dp(end + 1, n, s));
        }

        memo[start] = res;
        return memo[start];
    }

    private TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();

        for(String word : dict) {
            TrieNode node = root;

            for(char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }

            node.isWord = true;
        }

        return root;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}
