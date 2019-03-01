package binarysearch;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("ahc", "ahbgdc"));
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("agc", "ahbgdc"));
        System.out.println(solution.isSubsequence("adc", "ahbgdc"));
        System.out.println(solution.isSubsequence("hbgc", "ahbgdc"));
        System.out.println(solution.isSubsequence("hgd", "ahbgdc"));
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("a", "ahbgdc"));
        System.out.println(solution.isSubsequence("g", "ahbgdc"));
        System.out.println(solution.isSubsequence("c", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
        System.out.println(solution.isSubsequence("acg", "ahbgdc"));
    }

    // 击败45.82%
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            // s是空,t不是空
            if ((s == null || s.length() == 0) && (t != null && t.length() > 0)) {
                return true;
            }

            // t是空,s不是空
            if ((t == null || t.length() == 0) && (s != null && s.length() > 0)) {
                return false;
            }

            int pa = 0, pb = 0;
            int sLen = s.length(), tLen = t.length();
            while (pa < sLen && pb < tLen) {
                while (pa < sLen && pb < tLen && s.charAt(pa) == t.charAt(pb)) {
                    pa++;
                    pb++;
                }
                while (pa < sLen && pb < tLen && s.charAt(pa) != t.charAt(pb)) {
                    pb++;
                }
            }
            return pa == sLen;
        }
    }
}
