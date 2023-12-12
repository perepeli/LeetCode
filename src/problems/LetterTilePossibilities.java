package problems;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, new StringBuilder(), set, visited);
        return set.size() - 1;
    }

    private void backtrack(String tiles, StringBuilder temp, Set<String> set, boolean[] visited) {
        set.add(temp.toString());
        for(int i = 0; i < tiles.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.append(tiles.charAt(i));
                backtrack(tiles, temp, set, visited);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
    }
}
