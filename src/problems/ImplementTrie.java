package problems;

public class ImplementTrie {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return true;
    }
}
