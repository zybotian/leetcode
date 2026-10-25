package y2006;

import java.util.Stack;

public class valid_kuohao {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_kuohao validKuohao = new valid_kuohao();
        System.out.println(validKuohao.isValid("()[]{}"));
        System.out.println(validKuohao.isValid("([{}])"));
        System.out.println(validKuohao.isValid("([]{})"));
        System.out.println(validKuohao.isValid("()[{}]"));
        System.out.println(validKuohao.isValid("([)]{}"));
        System.out.println(validKuohao.isValid("]"));
    }
}
