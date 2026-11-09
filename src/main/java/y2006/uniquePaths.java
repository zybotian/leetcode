package y2006;

public class uniquePaths {
    public static void main(String[] args) {
        uniquePaths uniquePaths = new uniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths.uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths.uniquePaths(7, 3)); // 28
        System.out.println(uniquePaths.uniquePaths(3, 3)); // 6
    }

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从【0，0】到【i，j】的路径数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
