package offer;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));// 1
        System.out.println(missingNumber(new int[]{1}));// 0
        System.out.println(missingNumber(new int[]{0, 2})); // 1
        System.out.println(missingNumber(new int[]{0, 1}));// 2
        System.out.println(missingNumber(new int[]{1, 2})); // 0

        System.out.println(missingNumber(new int[]{0, 1, 3}));// 2
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));// 8
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
