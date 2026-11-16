package y2006;

public class longestPalindrome {
    public static void main(String[] args) {
        longestPalindrome longestPalindrome = new longestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int sLen = s.length();
        // dp[i][j]表示字符串s[i...j]是否是回文字符串
        int bestStart = 0, maxLen = 1;
        boolean[][] dp = new boolean[sLen][sLen];

        // 外层循环字符串长度
        for (int currLen = 1; currLen <= sLen; currLen++) {
            // 内层循环遍历每个start位置
            for (int i = 0; i <= sLen - currLen; i++) {
                int j = i + currLen - 1;
                if (currLen == 1) {
                    dp[i][j] = true;
                } else if (currLen == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {// j-i>=2
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && currLen > maxLen) {
                    bestStart = i;
                    maxLen = currLen;
                }
            }
        }
        return s.substring(bestStart, bestStart + maxLen);
    }
}
