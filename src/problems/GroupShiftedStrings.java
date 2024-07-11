package problems;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            map.computeIfAbsent(computeKey(s), key -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(var entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String computeKey(String s) {
        StringBuilder sb = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty()) {
                if((stack.peek() < c && stack.peek() + 1 == c) || (stack.peek() == 'z' && c == 'a')) {
                    stack.push(c);
                } else {
                    sb.append('(');
                    sb.append(stack.size());
                    sb.append(')');

                    sb.append(computeOffset(stack.peek(), c));

                    stack.clear();

                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if(!stack.isEmpty()) {
            sb.append('(');
            sb.append(stack.size());
            sb.append(')');
        }

        return sb.toString();
    }

    private int computeOffset(int left, int right) {
        if(left < right) return (right - left + 1);
        else return ((26 - left) + (right) + 1);
    }
}
