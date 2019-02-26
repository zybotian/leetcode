package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class HasGroupsSizeX {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {1, 3, 2, 4, 2, 4, 3, 1};
        System.out.println(solution.hasGroupsSizeX(data));

        int[] data2 = {1, 3, 2, 3, 2, 3, 3, 1};
        System.out.println(solution.hasGroupsSizeX(data2));

        int[] data3 = {1, 3, 3, 3, 3, 3, 3, 1};
        System.out.println(solution.hasGroupsSizeX(data3));

        int[] data4 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.hasGroupsSizeX(data4));

        int[] data5 = {1, 1};
        System.out.println(solution.hasGroupsSizeX(data5));

        int[] data6 = {1, 10};
        System.out.println(solution.hasGroupsSizeX(data6));

        int[] data7 = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        System.out.println(solution.hasGroupsSizeX(data7));
    }

    static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            // 长度小于2的肯定不符合要求
            if (deck.length < 2) {
                return false;
            }

            Map<Integer, Integer> numCount = new HashMap<>();
            for (int i = 0; i < deck.length; i++) {
                Integer integer = numCount.get(deck[i]);
                if (integer == null) {
                    numCount.put(deck[i], 1);
                } else {
                    numCount.put(deck[i], 1 + numCount.get(deck[i]));
                }
            }

            // x取值范围[2,长度]
            int x = 2;
            for (; x <= deck.length; x++) {
                int count = 0;
                for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
                    if (entry.getValue() % x == 0) {
                        count++;
                    }
                }
                if (count == numCount.size()) {
                    return true;
                }
            }
            return false;
        }
    }
}
