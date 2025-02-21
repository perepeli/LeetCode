package problems;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        Deque<Character> stack = new LinkedList<>();

        Deque<Character> tempDeque= new LinkedList<>();

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);

            stack.addLast(c);

            if(stack.size() >= part.length()) {
                int index = part.length() - 1;

                while(index >= 0 && part.charAt(index) == stack.peekLast()) {
                    tempDeque.addLast(stack.removeLast());
                    index--;
                }

                if(index == -1) {
                    tempDeque.clear();
                } else {
                    while(!tempDeque.isEmpty()) {
                        stack.addLast(tempDeque.removeLast());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.poll());
        }

        return sb.toString();
    }
}
