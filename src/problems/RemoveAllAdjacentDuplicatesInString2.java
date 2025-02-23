package problems;

import problems.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peekLast().getKey() == c && stack.peekLast().getValue() + 1 == k) {
                for(int j = 1; j < k; j++) stack.removeLast();
            } else if(!stack.isEmpty() && stack.peekLast().getKey() == c) {
                stack.addLast(new Pair<>(c, stack.peekLast().getValue() + 1));
            } else {
                stack.addLast(new Pair<>(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.removeLast().getKey());
        return sb.reverse().toString();
    }
}
