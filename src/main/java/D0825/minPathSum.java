package D0825;

class minPathSum {

    public static void main(String[] args) {
        minPathSum minPathSum = new minPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(minPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // [0][0]->[i][j]的最小路径和
        int[][] result = new int[rows][cols];

        result[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            result[0][j] = result[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = Math.min(result[i - 1][j] + grid[i][j], result[i][j - 1] + grid[i][j]);
            }
        }

        return result[rows - 1][cols - 1];
    }
}