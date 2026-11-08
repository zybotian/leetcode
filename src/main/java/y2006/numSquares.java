package y2006;

import java.util.Arrays;

public class numSquares {
    public static void main(String[] args) {
        numSquares numSquares = new numSquares();
        System.out.println(numSquares.numSquares(12));// 4 4 4
        System.out.println(numSquares.numSquares(13)); // 4 9
        System.out.println(numSquares.numSquares(100)); // 10
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
