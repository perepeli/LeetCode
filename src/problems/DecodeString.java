package problems;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if(current == ']') {
                char previous = stack.pop();
                StringBuilder innerContent = new StringBuilder();

                while(previous  != '[') {
                    innerContent.append(previous);
                    previous = stack.pop();
                }

                StringBuilder multiplier = new StringBuilder();

                while(!stack.isEmpty()) {
                    if(Character.isDigit(stack.peek())) {
                        multiplier.append(stack.pop());
                    } else {
                        break;
                    }
                }

                String reversedContent = innerContent.reverse().toString();
                String reversedMultiplier = multiplier.reverse().toString();

                String finalString = reversedContent.repeat(Integer.valueOf(reversedMultiplier));

                for(int j = 0; j < finalString.length(); j++) {
                    stack.push(finalString.charAt(j));
                }

            } else {
                stack.push(current);
            }
        }

        StringBuilder finalStringReversed = new StringBuilder();
        while(!stack.isEmpty()) {
            finalStringReversed.append(stack.pop());
        }
        return(finalStringReversed.reverse().toString());

    }
}
