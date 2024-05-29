package problems;

public class ImplementMagicDictionary {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root;

    public ImplementMagicDictionary() {}

    public void buildDict(String[] dictionary) {
        root = new TrieNode();

        for(String word : dictionary) {
            TrieNode temp = root;

            for(int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                int index = currChar - 'a';

                if(temp.children[index] == null) temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }

            temp.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return searchInternal(searchWord, 0, 1, root);
    }

    private boolean searchInternal(String searchWord, int index, int allowedErrors, TrieNode node) {
        if(index == searchWord.length()) {
            if(node.isWord && allowedErrors == 0) return true;
            return false;
        }

        char currChar = searchWord.charAt(index);

        for(int i = 0; i < 26; i++) {
            if(node.children[i] == null) continue;
            if(allowedErrors == 0 && currChar != i + 'a') continue;
            if(searchInternal(searchWord, index + 1, currChar == (char) i + 'a' ? allowedErrors : allowedErrors - 1, node.children[i])) return true;
        }

        return false;
    }
}
