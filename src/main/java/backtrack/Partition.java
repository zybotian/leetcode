package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition {

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("a"));
        System.out.println(partition.partition("aab"));
        System.out.println(partition.partition("aabbaa"));
    }

    /**
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();
        backtrack(s, result, tmp, 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, LinkedList<String> tmpResult, int index) {
        if (index == s.length()) {
            if (isSolution(s, tmpResult)) {
                result.add(new LinkedList<>(tmpResult));
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring, 0, substring.length() - 1)) {
                // 选择
                tmpResult.add(substring);
                // 推进
                backtrack(s, result, tmpResult, i + 1);
                // 回溯
                tmpResult.removeLast();
            }
        }
    }

    private boolean isSolution(String s, List<String> tmpResult) {
        StringBuilder sb = new StringBuilder();
        for (String str : tmpResult) {
            if (!isPalindrome(str, 0, str.length() - 1)) {
                return false;
            }
            sb.append(str);
        }
        return sb.toString().equals(s);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left > right) {
            return false;
        }
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
