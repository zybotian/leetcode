package graph;

/**
 * @author tianbo
 * @date 2019-06-10
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        MaxAreaOfIsland test = new MaxAreaOfIsland();
        System.out.println(test.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int result = 1;
        // 右边
        if (i + 1 < grid.length) {
            result += dfs(i + 1, j, grid);
        }
        // 下边
        if (j + 1 < grid[0].length) {
            result += dfs(i, j + 1, grid);
        }
        // 左边
        if (i - 1 >= 0 && i - 1 < grid.length) {
            result += dfs(i - 1, j, grid);
        }
        // 上边
        if (j - 1 >= 0 && j - 1 < grid[0].length) {
            result += dfs(i, j - 1, grid);
        }
        return result;
    }
}
