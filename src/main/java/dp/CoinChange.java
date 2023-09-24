package dp;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "==" + coinChange.coinChange(coins, i));
        }

        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{2}, 0));
    }

    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            // 初始值设为i
            result[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    result[i] = Math.min(result[i], result[i - coins[j]] + 1);
                }
            }
        }
        return result[amount] > amount ? -1 : result[amount];
    }
}
