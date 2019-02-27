package twopointers;

/**
 * @author tianbo
 * @date 2019-02-27
 */
public class IsLongPressedName {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(solution.isLongPressedName("leelee", "lleeelee"));
        System.out.println(solution.isLongPressedName("laiden", "laiden"));
        System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));
    }

    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            if (name.length() > typed.length()) {
                return false;
            }

            char[] charsName = name.toCharArray();
            char[] charsTyped = typed.toCharArray();

            int i = 0, j = 0;
            int s = 0, e = 0;
            while (i < charsName.length && s < charsTyped.length) {
                // 字母不同, 无需再进行判断
                if (charsName[i] != charsTyped[s]) {
                    return false;
                }

                // [i,j)圈定名字里面同一个字符连续出现的下标范围
                while (j < charsName.length && charsName[j] == charsName[i]) {
                    j++;
                }

                // [s,e)圈定输入名字里面同一个字符连续出现的下标范围
                while (e < charsTyped.length && charsTyped[e] == charsTyped[s]) {
                    e++;
                }

                // 同一个字母名字中连续出现的次数大于输入中连续出现的次数
                if (j - i > e - s) {
                    return false;
                }
                i = j;
                s = e;
                j++;
                e++;
            }
            return i == charsName.length && s == charsTyped.length;
        }
    }
}
