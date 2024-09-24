package problems;

public class LongestWordWithAllPrefixes {
    private String result;

    public String longestWord(String[] words) {
        result = "";
        TrieNode trie = new TrieNode();
        for(String word : words) addWord(word, 0, trie);
        for(int i = 0; i < trie.children.length; i++) {
            char c = (char)(i + 'a');
            if(trie.children[i] != null)
                longestValidDepth(trie.children[i], new StringBuilder().append(c));
        }
        return result;
    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    public void addWord(String word, int index, TrieNode node) {
        if(index == word.length()) return;

        int childrenIndex = word.charAt(index) - 'a';
        if(node.children[childrenIndex] == null) node.children[childrenIndex] = new TrieNode();

        TrieNode children = node.children[childrenIndex];
        if(index == word.length() - 1) children.isWord = true;

        addWord(word, index + 1, node.children[childrenIndex]);

    }

    public void longestValidDepth(TrieNode node, StringBuilder sb) {
        if(node == null || !node.isWord) return;
        if(node.isWord) {
            if(sb.length() > result.length()) {
                result = sb.toString();
            }

            for(int i = 0; i < node.children.length; i++) {
                char c = (char)(i + 'a');
                sb.append(c);
                longestValidDepth(node.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
