package array;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 0, 0};
        int[] arr2 = {1, 1, 0};
        int[] arr3 = {1, 1, 1, 0};
        int[] arr4 = {1, 0, 1};
        int[] arr5 = {1, 1, 1};
        int[] arr6 = {1, 1, 1, 1};

        System.out.println(solution.isOneBitCharacter(arr1));
        System.out.println(solution.isOneBitCharacter(arr2));
        System.out.println(solution.isOneBitCharacter(arr3));
        System.out.println(solution.isOneBitCharacter(arr4));
        System.out.println(solution.isOneBitCharacter(arr5));
        System.out.println(solution.isOneBitCharacter(arr6));
    }

    static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            while (i < bits.length - 1) {
                if (bits[i] == 1 && (bits[i + 1] == 1 || bits[i + 1] == 0)) {
                    i += 2;
                } else if (bits[i] == 0) {
                    i++;
                }
            }
            return i == bits.length - 1 && bits[i] == 0;
        }
    }
}
