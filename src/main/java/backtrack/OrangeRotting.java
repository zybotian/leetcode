package backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class OrangeRotting {

    public int orangesRotting(int[][] grid) {
        int good = 0;
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    good++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (good == 0) {
            return result;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && good > 0) {
            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {
                int[] xy = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int x = xy[0] + dirs[j][0];
                    int y = xy[1] + dirs[j][1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            queue.add(new int[]{x, y});
                            good--;
                        }
                    }
                }
            }
        }
        if (good == 0) {
            return result;
        }

        return -1;
    }
}
