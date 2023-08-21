package twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author tianbo
 * @date 2019-02-28
 */
public class FindLongestWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("".equals(solution.findLongestWord("smaat", Arrays.asList("smart"))));
        System.out.println("smart".equals(solution.findLongestWord("abssamarrt", Arrays.asList("smart"))));
        System.out.println("apple".equals(solution.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey",
                "plea"))));
        System.out.println("a".equals(solution.findLongestWord("abpcplea", Arrays.asList("a", "p", "c", "b"))));
    }

    // 击败71.38%
    static class Solution {
        public String findLongestWord(String s, final List<String> d) {
            // 排序时间复杂度O(n*log(n)),排序的目的是在找到第一个节之后结束程序
            Collections.sort(d, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // 长度长的字符串排在前面
                    int diff = o2.length() - o1.length();
                    // 长度相同的,字符串按字典顺序排
                    return diff != 0 ? diff : o1.compareTo(o2);
                }
            });

            int size = d.size();
            for (int i = 0; i < size; i++) {
                String dStr = d.get(i);
                // 找到了匹配的, 返回
                if (match(s, dStr)) {
                    return dStr;
                }
            }
            // 没找到, 返回空字符串
            return "";
        }

        // 时间复杂度O(m+n)
        private boolean match(String src, String dic) {
            char[] charsSrc = src.toCharArray();
            char[] charsDic = dic.toCharArray();
            int pa = 0, pb = 0;
            while (pa < charsSrc.length && pb < charsDic.length) {
                // 跳过不相同的字符, 直到找到第一个相同的字符
                while (pa < charsSrc.length && charsSrc[pa] != charsDic[pb]) {
                    pa++;
                }
                // 找到头都没找到, 说明不匹配
                if (pa == charsSrc.length) {
                    return false;
                }

                while (pa < charsSrc.length && pb < charsDic.length && charsSrc[pa] == charsDic[pb]) {
                    pa++;
                    pb++;
                }
            }
            return pb == charsDic.length;
        }
    }
}
