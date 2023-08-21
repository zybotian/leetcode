package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class FindPairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 1, 4, 1, 5};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] nums3 = {1, 3, 1, 5, 4};
        int[] nums4 = {1, 2, 3, 4, 5};

        System.out.println(solution.findPairs(nums1, 2));
        System.out.println(solution.findPairs(nums2, 1));
        System.out.println(solution.findPairs(nums3, 0));
        System.out.println(solution.findPairs(nums4, -1));
    }

    static class Solution {
        // 击败了51.44%
        // 1,1,3,4,5:2
        // 1,2,3,4,5:1
        // 1,1,3,4,5:0
        // 1,2,3,4,5:-1
        public int findPairs(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 0) {
                return 0;
            }
            Map<Integer, Integer> numCount = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = numCount.get(nums[i]);
                if (integer == null) {
                    numCount.put(nums[i], 1);
                } else {
                    numCount.put(nums[i], 1 + numCount.get(nums[i]));
                }
            }

            Set<String> pairSet = new HashSet<>();
            for (Integer integer : numCount.keySet()) {
                if (k == 0) {
                    if (numCount.get(integer) > 1) {
                        pairSet.add(integer + "");
                    }
                } else {
                    if (numCount.containsKey(integer + k)) {
                        pairSet.add(integer + "_" + (integer + k));
                    }
                }
            }
            return pairSet.size();
        }
    }

    static class Solution1 {
        // 击败5.4%, 效率低下
        public int findPairs(int[] nums, int k) {
            Set<String> pairSet = new HashSet<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) == k) {
                        pairSet.add(Math.min(nums[i], nums[j]) + "_" + Math.max(nums[i], nums[j]));
                    }
                }
            }
            return pairSet.size();
        }
    }
}
