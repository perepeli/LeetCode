package problems;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String s : products) trie.insert(s);

        List<List<String>> res = new ArrayList<>();
        for(int i = 1; i <= searchWord.length(); i++) {
            res.add(trie.search(searchWord.substring(0, i)));
        }
        return res;
    }

    static class Trie {
        TrieNode root;
        List<String> resultBuffer;

        Trie() {
            root = new TrieNode();
        }

        List<String> search(String searchWord) {
            resultBuffer = new ArrayList<>();
            searchInternal(searchWord, 0, root, new StringBuilder());
            return resultBuffer;
        }

        void searchInternal(String searchWord, int idx, TrieNode node, StringBuilder sb) {
            if(idx < searchWord.length()) {
                if(node.children[searchWord.charAt(idx) - 'a'] == null) return;
                searchInternal(searchWord, idx + 1, node.children[searchWord.charAt(idx) - 'a'], sb);
            } else {
                if(resultBuffer.size() == 3) return;
                if(node.isWord) resultBuffer.add(searchWord + sb.toString());

                for(int i = 0; i < 26; i++) {
                    if(node.children[i] != null) {
                        char c = (char)( i + 'a');

                        sb.append(c);
                        searchInternal(searchWord, idx + 1, node.children[i], sb);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }

        void insert(String s) {
            TrieNode temp = root;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';
                if(temp.children[index] == null) temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }

            temp.isWord = true;
        }


        static class TrieNode {
            boolean isWord = false;
            TrieNode[] children = new TrieNode[26];
        }
    }
}
