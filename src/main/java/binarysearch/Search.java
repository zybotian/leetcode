package binarysearch;

import util.SequenceUtils;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class Search {
    public static void main(String[] args) {
        int[] data = SequenceUtils.generate(1000);
        System.out.println(Arrays.toString(data));

        long time1 = System.currentTimeMillis();
        Solution1 solution = new Solution1();
        System.out.println(solution.search(data, 999999));
        long time2 = System.currentTimeMillis();

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.search(data, 999999));
        long time3 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(time3 - time2);

    }

    // 100%, 说明case设置不好
    static class Solution1 {
        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    // 100%, case设置不合理
    static class Solution2 {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
