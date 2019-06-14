package offer;

/**
 * @author tianbo
 * @date 2019-06-13
 */
public class RobotRange {

    public static void main(String[] args) {
        System.out.println(robotRange(10, 10, 5));
        System.out.println(robotRange(1, 1, 1));
        // ->0,0 ->0,1 ->1,0
        System.out.println(robotRange(10, 10, 1));
        // ->0,0 ->0,1 ->1,0 ->1,1 ->0,2 ->2,0
        System.out.println(robotRange(10, 10, 2));
    }

    public static int robotRange(int rows, int cols, int k) {
        if (rows <= 0 || cols <= 0 || k <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return robotRangeCore(rows, cols, k, 0, 0, visited);
    }

    private static int robotRangeCore(int rows, int cols, int k, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        int count = 0;
        if (!visited[row][col] && checkPass(row, col, k)) {
            visited[row][col] = true;
            count = 1
                    + robotRangeCore(rows, cols, k, row + 1, col, visited)
                    + robotRangeCore(rows, cols, k, row, col + 1, visited)
                    + robotRangeCore(rows, cols, k, row - 1, col, visited)
                    + robotRangeCore(rows, cols, k, row, col - 1, visited);
        }
        return count;
    }

    private static boolean checkPass(int row, int col, int k) {
        return sumDigits(row) + sumDigits(col) <= k;
    }

    private static int sumDigits(int data) {
        int sum = 0;
        while (data != 0) {
            sum += data % 10;
            data /= 10;
        }
        return sum;
    }
}
