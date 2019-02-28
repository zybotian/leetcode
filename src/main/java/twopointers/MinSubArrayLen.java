package twopointers;

/**
 * @author tianbo
 * @date 2019-02-28
 */
public class MinSubArrayLen {

    // 时间复杂度降低为n, 击败99.91%
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0;
            int i = 0, left = 0;
            int result = Integer.MAX_VALUE;
            while (i < nums.length) {
                sum += nums[i];
                // 这里不能用if,应该要把前面的数字都减掉直到当前的和小于s
                while (sum >= s) {
                    result = Math.min(result, i + 1 - left);
                    sum -= nums[left];
                    left++;
                }
                i++;
            }

            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

    // 时间复杂度为平方, 击败12.30%,效率不行
    static class Solution1 {
        public int minSubArrayLen(int s, int[] nums) {
            int i = 0, j = 0;
            int sum = 0;
            int result = Integer.MAX_VALUE;
            while (j < nums.length) {
                while (sum < s && j < nums.length) {
                    sum += nums[j];
                    j++;
                }
                if (sum >= s) {
                    result = Math.min(result, j - i);
                    i++;
                    j = i;
                    sum = 0;
                }
            }
            return result < Integer.MAX_VALUE ? result : 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(1, arr));
        System.out.println(solution.minSubArrayLen(2, arr));
        System.out.println(solution.minSubArrayLen(3, arr));
        System.out.println(solution.minSubArrayLen(4, arr));
        System.out.println(solution.minSubArrayLen(5, arr));
        System.out.println(solution.minSubArrayLen(6, arr));
        System.out.println(solution.minSubArrayLen(7, arr));
        System.out.println(solution.minSubArrayLen(8, arr));
        System.out.println(solution.minSubArrayLen(200, arr));
    }
}
