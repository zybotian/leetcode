package D0725;

import java.util.Stack;

class isValid {

    public static void main(String[] args) {
        isValid isValid = new isValid();
        System.out.println(isValid.isValid("{{([])}}"));
        System.out.println(isValid.isValid("{{([])}})"));
        System.out.println(isValid.isValid("{{([])}}["));
        System.out.println(isValid.isValid("{{([])}}[]"));

    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, size = s.length(); i < size; i++) {
            char charAt = s.charAt(i);
            if (charAt == '{' || charAt == '[' || charAt == '(') {
                stack.push(charAt);
            } else if (charAt == '}' || charAt == ']' || charAt == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (charAt == '}' && peek == '{') {
                    stack.pop();
                } else if (charAt == ']' && peek == '[') {
                    stack.pop();
                } else if (charAt == ')' && peek == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}