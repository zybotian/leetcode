package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        for (int i = 1; i <= 4; i++) {
            System.out.println(generateParenthesis.generateParenthesis(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, n, sb, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int n, StringBuilder sb, int left, int right) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        if (left > n || right > n) {
            return;
        }
        if (left < n) {
            // 选择左括号
            sb.append("(");
            backtrack(result, n, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            // 选择右括号
            sb.append(")");
            backtrack(result, n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
