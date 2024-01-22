package problems;

import java.util.LinkedList;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Character> list = new LinkedList<>();

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                list.add(c);
                leftCount++;
            }  else if (c == ')') {
                if(leftCount > rightCount) {
                    list.add(c);
                    rightCount++;
                }
            } else {
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()) {
            char c = list.removeLast();
            if(c == '(' && leftCount > rightCount) {
                leftCount--;
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
