package y2006;

import java.util.Arrays;

public class jump {
    public int jump(int[] nums) {
        // dp[i]表示跳到i位置的最小跳跃步数
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        jump jump = new jump();
        System.out.println(jump.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
