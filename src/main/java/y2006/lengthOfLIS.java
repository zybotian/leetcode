package y2006;

import java.util.Arrays;

public class lengthOfLIS {
    public static void main(String[] args) {
        lengthOfLIS lengthOfLIS = new lengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
