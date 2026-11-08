package y2006;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示金额为i时的最小硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChange coinChange = new coinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{1}, 0));
    }
}
