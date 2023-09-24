package dp;

import java.util.Arrays;

public class CanPartition {

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 1, 2, 2}));

    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[][] result = new boolean[len][target + 1];
        if (nums[0] <= target) {
            result[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                result[i][j] = result[i - 1][j] || nums[i] == j || nums[i] < j && result[i - 1][j - nums[i]];
            }
        }

        return result[len - 1][target];
    }
}
