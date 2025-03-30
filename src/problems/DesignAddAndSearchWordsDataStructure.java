package problems;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.children[index] == null) temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        return searchDfs(root, word, 0);
    }

    private boolean searchDfs(TrieNode temp, String word, int index) {
        if(index == word.length()) {
            return temp.isWord;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(int i = 0; i < temp.children.length; i++) {
                if(temp.children[i] == null) continue;
                if(searchDfs(temp.children[i], word, index + 1)) return true;
            }
            return false;
        } else {
            int childIndex = c - 'a';
            if(temp.children[childIndex] == null) return false;
            return searchDfs(temp.children[childIndex], word, index + 1);
        }
    }
}
