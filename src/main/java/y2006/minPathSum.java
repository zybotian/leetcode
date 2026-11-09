package y2006;

public class minPathSum {
    public static void main(String[] args) {
        minPathSum minPathSum = new minPathSum();
        System.out.println(minPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(minPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(minPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // dp[i][j]表示从[0,0]到[i,j]的最小路径和

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
