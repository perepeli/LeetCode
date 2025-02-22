package problems;

import java.util.Deque;
import java.util.LinkedList;

public class ClearDigits {
    public String clearDigits(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                if(!deque.isEmpty() && Character.isLetter(deque.peekLast())) {
                    deque.removeLast();
                } else {
                    deque.addLast(c);
                }
            } else {
                deque.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) sb.append(deque.removeFirst());
        return sb.toString();
    }
}
