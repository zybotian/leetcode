package graph;

/**
 * @author tianbo
 * @date 2019-06-10
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands test = new NumberOfIslands();
        System.out.println(test.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 右边
        if (i + 1 < grid.length) {
            dfs(i + 1, j, grid);
        }
        // 下边
        if (j + 1 < grid[0].length) {
            dfs(i, j + 1, grid);
        }
        // 左边
        if (i - 1 >= 0 && i - 1 < grid.length) {
            dfs(i - 1, j, grid);
        }
        // 上边
        if (j - 1 >= 0 && j - 1 < grid[0].length) {
            dfs(i, j - 1, grid);
        }
    }
}
