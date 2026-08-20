package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();

        for(String s : logs) {
            if("../".equals(s)) {
                if(!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if("./".equals(s)) {
                continue;
            } else {
                stack.add(s);
            }
        }

        return stack.size();
    }
}
