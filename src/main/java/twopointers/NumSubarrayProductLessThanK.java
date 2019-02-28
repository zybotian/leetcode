package twopointers;

/**
 * @author tianbo
 * @date 2019-02-28
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 5, 2, 6};
        int[] arr2 = {1, 1, 1};
        System.out.println(solution.numSubarrayProductLessThanK(arr, 100));
        System.out.println(solution.numSubarrayProductLessThanK(arr2, 1));
    }

    // 击败100%
    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // 因为nums[i]全是正数,即使全是1,乘积也不可能小于1
            if (k <= 1) {
                return 0;
            }

            int pa = 0, pb = 0;
            int product = 1, result = 0;

            while (pb < nums.length) {
                product *= nums[pb];
                while (product >= k) {
                    product /= nums[pa];
                    pa++;
                }
                result += pb - pa + 1;
                pb++;
            }

            return result;
        }
    }
}
