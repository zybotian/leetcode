package dp;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
        System.out.println(uniquePaths.uniquePaths(7, 3));
        System.out.println(uniquePaths.uniquePaths(3, 3));

    }

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从【0，0】到【i+1行，j+1列】的矩阵的路径数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    // 递归，超时
    public int uniquePaths2(int m, int n) {
        return findPaths(0, 0, m - 1, n - 1);
    }

    private int findPaths(int startRow, int startCol, int targetRow, int targetCol) {
        if (startRow < 0 || startRow > targetRow || startCol < 0 || startCol > targetCol) {
            return 0;
        }

        if (startRow == targetRow && startCol == targetCol) {
            return 1;
        }
        return findPaths(startRow + 1, startCol, targetRow, targetCol) + findPaths(startRow, startCol + 1, targetRow, targetCol);
    }
}
