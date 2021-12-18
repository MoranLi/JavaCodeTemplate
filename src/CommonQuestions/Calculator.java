package CommonQuestions;

import java.util.Stack;

public class Calculator {
    int i = 0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int n = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) n = n * 10 + (c - '0');
            if(c == '(') n = calculate(s);
            if(i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')'){
                if(operator == '+') stack.add(n);
                if(operator == '-') stack.add(-n);
                if(operator == '*') stack.add(stack.pop() * n);
                if(operator == '/') stack.add(stack.pop() / n);
                operator = c;
                n = 0;
            }
            if(c == ')') break;
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}
