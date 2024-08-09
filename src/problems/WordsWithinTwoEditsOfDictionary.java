package problems;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        TrieNode trie = buildTrie(dictionary);

        for(String query : queries) {
            String word = findWordWithEdits(query, 0, trie, 2);
            if(word != null) res.add(word);
        }

        return res;
    }

    private static class TrieNode {
        String word;
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord = false;

        public TrieNode(String word) {
            this.word = word;
        }
    }

    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode("");

        for(String word : dictionary) {
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++) {
                if(temp.nodes[word.charAt(i) - 'a'] == null) {
                    temp.nodes[word.charAt(i) - 'a'] = new TrieNode(temp.word + word.charAt(i));
                }

                temp = temp.nodes[word.charAt(i) - 'a'];
            }

            temp.isWord = true;
        }

        return root;
    }

    private String findWordWithEdits(String word, int index, TrieNode node, int amountOfEdits) {
        if(amountOfEdits < 0) return null;
        if(index == word.length()) {
            return node.isWord ? word : null;
        } else {
            for(int i = 0; i < 26; i++) {
                String result = null;

                if(node.nodes[i] != null) {
                    result = findWordWithEdits(word, index + 1, node.nodes[i], word.charAt(index) == i + 'a' ? amountOfEdits : amountOfEdits - 1);
                }

                if(result != null) return result;
            }

            return null;
        }
    }
}
