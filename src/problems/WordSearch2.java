package problems;

import java.util.*;

class TrieNodeZ {
    HashMap<Character, TrieNodeZ> children = new HashMap<Character, TrieNodeZ>();
    String word = null;
}

public class WordSearch2 {

    private static int[][] DIR = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        TrieNodeZ trie = constructTrie(words);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, trie, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(char[][] board, int r, int c, TrieNodeZ node, Set<String> result) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if(node == null) return;

        char curr = board[r][c];
        if(curr == '#') return;

        TrieNodeZ currNode = node.children.get(curr);
        if(currNode == null) return;

        if(currNode.word != null) result.add(currNode.word);

        board[r][c] = '#';

        for(int[] dir : DIR) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            backtrack(board, newR, newC, currNode, result);
        }

        board[r][c] = curr;
    }

    private TrieNodeZ constructTrie(String[] words) {
        TrieNodeZ root = new TrieNodeZ();

        for(String s : words) {
            TrieNodeZ temp = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!temp.children.containsKey(c)) temp.children.put(c, new TrieNodeZ());
                temp = temp.children.get(c);
            }
            temp.word = s;
        }

        return root;
    }
}
