package dp;

public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob.rob(new int[]{2}));
        System.out.println(rob.rob(new int[]{2, 3}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
