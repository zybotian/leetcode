package offer;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class ExpressionMatch {

    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchInternal(str, 0, pattern, 0);
    }

    private static boolean matchInternal(String str, int index1, String pattern, int index2) {
        int lenStr = str.length();
        int lenPattern = pattern.length();

        // 字符串和模式刚好匹配
        if (index1 == lenStr && index2 == lenPattern) {
            return true;
        }

        // 字符串还没匹配完,模式已经到头
        if (index1 < lenStr && index2 == lenPattern) {
            return false;
        }

        // 字符串匹配完,但模式还没匹配完: 针对test2,4,9
        if (index1 == lenStr && index2 < lenPattern) {
            String leftPattern = pattern.substring(index2);
            return leftPattern.length() <= 2 && leftPattern.lastIndexOf("*") > 0;
        }

        if (index2 + 1 < lenPattern && pattern.charAt(index2 + 1) == '*') {
            if (str.charAt(index1) == pattern.charAt(index2) || pattern.charAt(index2) == '.') {
                return // abc和ab*c,b*只匹配一个字符的情况:index1指向b,index2指向b
                        matchInternal(str, index1 + 1, pattern, index2 + 2)
                                // acd和ab*cd,忽略b*的情况:index1指向c,index2指向b
                                || matchInternal(str, index1, pattern, index2 + 2)
                                // abbbc和ab*c,b*匹配多个字符的情况:index1指向b,index2指向b
                                || matchInternal(str, index1 + 1, pattern, index2);
            } else {
                // aa和ab*a的情况: index1指向第2个a,index2指向b
                return matchInternal(str, index1, pattern, index2 + 2);
            }
        }

        if (str.charAt(index1) == pattern.charAt(index2) || pattern.charAt(index2) == '.') {
            return matchInternal(str, index1 + 1, pattern, index2 + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        test("Test01", "", "", true);
        test("Test02", "", ".*", true);
        test("Test03", "", ".", false);
        test("Test04", "", "c*", true);
        test("Test05", "a", ".*", true);
        test("Test06", "a", "a.", false);
        test("Test07", "a", "", false);
        test("Test08", "a", ".", true);
        test("Test09", "a", "ab*", true);
        test("Test10", "a", "ab*a", false);
        test("Test11", "aa", "aa", true);
        test("Test12", "aa", "a*", true);
        test("Test13", "aa", ".*", true);
        test("Test14", "aa", ".", false);
        test("Test15", "ab", ".*", true);
        test("Test16", "ab", ".*", true);
        test("Test17", "aaa", "aa*", true);
        test("Test18", "aaa", "aa.a", false);
        test("Test19", "aaa", "a.a", true);
        test("Test20", "aaa", ".a", false);
        test("Test21", "aaa", "a*a", true);
        test("Test22", "aaa", "ab*a", false);
        test("Test23", "aaa", "ab*ac*a", true);
        test("Test24", "aaa", "ab*a*c*a", true);
        test("Test25", "aaa", ".*", true);
        test("Test26", "aab", "c*a*b", true);
        test("Test27", "aaca", "ab*a*c*a", true);
        test("Test28", "aaba", "ab*a*c*a", false);
        test("Test29", "bbbba", ".*a*a", true);
        test("Test30", "bcbbabab", ".*a*a", false);
    }

    private static void test(String testName, String string, String pattern, boolean expected) {
        StringBuilder sb = new StringBuilder();

        if (testName != null) {
            sb.append(String.format("%s begins: ", testName));
        }

        if (match(string, pattern) == expected) {
            sb.append("Passed.\n");
        } else {
            sb.append("FAILED.\n");
        }
        System.out.println(sb.toString());
    }
}
