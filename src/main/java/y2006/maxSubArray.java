package y2006;

public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray maxSubArray = new maxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }


    public int maxSubArray2(int[] nums) {
        // dp[i]表示以nums[i]结尾的最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
