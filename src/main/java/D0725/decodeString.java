package D0725;

import java.util.Stack;

public class decodeString {
    public static void main(String[] args) {
        decodeString decodeString = new decodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        int multi = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                res.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + Integer.parseInt(ch + "");
            } else if (ch == '[') {
                multiStack.push(multi);
                resStack.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                Integer number = multiStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < number; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.pop() + tmp);
            }
        }
        return res.toString();
    }


}