package binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class RandomPickWithWeight {

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4};
        Solution solution = new Solution(w);
        Map<Integer, Integer> map = new HashMap<>(4, 1);
        for (int i = 1; i <= 10000; i++) {
            int pickIndex = solution.pickIndex();
            if (map.get(pickIndex) == null) {
                map.put(pickIndex, 1);
            } else {
                map.put(pickIndex, 1 + map.get(pickIndex));
            }
        }
        System.out.println(map);
    }

    // 击败 100%
    static class Solution {
        // 例如:  w  1 2 3 4
        // 则:  cu 1 3 6 10
        int[] cumulation;
        Random random = new Random();

        public Solution(int[] w) {
            cumulation = new int[w.length];
            cumulation[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                cumulation[i] = cumulation[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            // 随机选取1-10之间的一个数
            int val = random.nextInt(cumulation[cumulation.length - 1]) + 1;

            // 寻找该数字在cum中的下标, 即为所求
            int low = 0, high = cumulation.length - 1;
            while (low < high) {
                int mid = (low + high) >> 1;
                if (cumulation[mid] >= val) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
