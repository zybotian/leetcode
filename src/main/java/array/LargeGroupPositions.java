package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largeGroupPositions("abbxxxxzzy"));
        System.out.println(solution.largeGroupPositions("abc"));
        System.out.println(solution.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(solution.largeGroupPositions("aa"));
        System.out.println(solution.largeGroupPositions("aaaa"));

    }

    static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            char[] chars = S.toCharArray();
            int i = 0, j = 1;
            List<List<Integer>> result = new ArrayList<>();
            while (j < chars.length) {
                while (j < chars.length && chars[i] == chars[j]) {
                    j++;
                }
                if (j - i >= 3) {
                    List<Integer> tmp = new ArrayList<>(2);
                    tmp.add(i);
                    tmp.add(j - 1);
                    result.add(tmp);
                }
                i = j;
                j = i + 1;
            }

            return result;
        }
    }
}
