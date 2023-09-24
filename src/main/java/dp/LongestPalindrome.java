package dp;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // dp[i][j]表示字符串下标从i到j这部分是回文字符串
        int strLen = s.length();
        boolean[][] dp = new boolean[strLen][strLen];
        dp[0][0] = true;

        int start = 0, maxLen = 1;
        for (int right = 1; right < strLen; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;

                    if (maxLen < right - left + 1) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
