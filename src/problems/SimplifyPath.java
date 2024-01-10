package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        String[] tokens = path.split("/");

        StringBuilder sb = new StringBuilder();

        for(String token : tokens) {
            if(token.equals(".") || token.equals("")) {
                continue;
            } else if (token.equals("..")) {
                if(deque.size() > 0) deque.removeLast();
            } else {
                deque.addLast(token);
            }
        }

        sb.append("/");
        for(String s : deque) {
            sb.append(s);
            sb.append("/");
        }
        if(sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
