package problems;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int i : arr1) trie.insert(i);
        int max = 0;
        for(int i : arr2) {
            max = Math.max(max, trie.findLongestPrefix(i));
        }

        return max;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            String numString = Integer.toString(num);
            for(char digit : numString.toCharArray()) {
                int index = digit - '0';
                if(node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
        }

        int findLongestPrefix(int num) {
            TrieNode node = root;
            String numString = Integer.toString(num);
            int len = 0;

            for(char digit : numString.toCharArray()) {
                int index = digit - '0';
                if(node.children[index] != null) {
                    len++;
                    node = node.children[index];
                } else {
                    break;
                }
            }

            return len;
        }
    }
}
