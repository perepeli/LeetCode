package problems;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if("+-*/".contains(s)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();

                if("+".equals(s)) stack.push(firstOperand + secondOperand);
                else if ("-".equals(s)) stack.push(firstOperand - secondOperand);
                else if ("*".equals(s)) stack.push(firstOperand * secondOperand);
                else if ("/".equals(s)) stack.push(firstOperand / secondOperand);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
