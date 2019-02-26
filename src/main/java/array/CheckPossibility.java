package array;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class CheckPossibility {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data1 = {4, 2, 3};// true
        int[] data2 = {4, 2, 1};// false
        int[] data3 = {1, 2, 1};// true
        int[] data4 = {1, 1};//true
        int[] data5 = {3, 4, 2, 3};// false
        int[] data6 = {-1, 4, 2, 3};// true
        int[] data7 = {3, 3, 2, 2};// false
        int[] data8 = {1, 2, 5, 3, 3};// true
        int[] data9 = {2, 3, 3, 2, 4};// true

        System.out.println(solution.checkPossibility(data1));
        System.out.println(solution.checkPossibility(data2));
        System.out.println(solution.checkPossibility(data3));
        System.out.println(solution.checkPossibility(data4));
        System.out.println(solution.checkPossibility(data5));
        System.out.println(solution.checkPossibility(data6));
        System.out.println(solution.checkPossibility(data7));
        System.out.println(solution.checkPossibility(data8));
        System.out.println(solution.checkPossibility(data9));
    }

    static class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums.length <= 1) {
                return true;
            }

            int i = 0, j = 1;
            int count = 0;
            while (j < nums.length) {
                if (nums[i] > nums[j]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                    if (j < nums.length - 1 && i >= 1 && nums[i] > nums[j + 1] && nums[j] < nums[i - 1]) {
                        return false;
                    }
                }
                i = j;
                j++;
            }
            return true;
        }
    }
}
