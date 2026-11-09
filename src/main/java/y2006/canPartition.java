package y2006;

import java.util.Arrays;

public class canPartition {
    public static void main(String[] args) {
        canPartition canPartition = new canPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 1, 2, 2}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
