package string;

/**
 * @author tianbo
 * @date 2019-03-08
 */
public class CheckRecord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
        System.out.println(solution.checkRecord("LLLALL"));
        System.out.println(solution.checkRecord("LLALL"));
        System.out.println(solution.checkRecord("PALLPALL"));
        System.out.println(solution.checkRecord("PPAAA"));
        System.out.println(solution.checkRecord("PPAAL"));

    }

    // 击败88.78%
    static class Solution {
        public boolean checkRecord(String s) {
            int countA = 0, countL = 0;
            for (int i = 0; i < s.length(); i++) {
                if ('L' == s.charAt(i)) {
                    countL++;
                    if (countL > 2) {
                        return false;
                    }
                } else {
                    countL = 0;
                    if ('A' == s.charAt(i)) {
                        countA++;
                    }
                }
            }

            return countA <= 1 && countL <= 2;
        }
    }
}
