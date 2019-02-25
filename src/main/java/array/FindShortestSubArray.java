package array;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class FindShortestSubArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 2, 3, 1};
        int[] arr2 = {2, 1, 2, 3, 1, 1, 2};

        System.out.println(solution.findShortestSubArray(arr1));
        System.out.println(solution.findShortestSubArray(arr2));

    }

    static class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> set = map.get(nums[i]);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(nums[i], set);
                }
                set.add(i);
            }

            int maxSize = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() >= maxSize) {
                    maxSize = entry.getValue().size();
                }
            }

            int minDiff = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == maxSize) {
                    TreeSet<Integer> treeSet = new TreeSet<>(entry.getValue());
                    int indexDiff = treeSet.last() - treeSet.first() + 1;
                    if (indexDiff < minDiff) {
                        minDiff = indexDiff;
                    }
                }
            }
            return minDiff;
        }
    }
}
