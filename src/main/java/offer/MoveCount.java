package offer;

public class MoveCount {
    public static void main(String[] args) {
        MoveCount moveCount = new MoveCount();
        System.out.println(moveCount.movingCount(40, 40, 18));
        System.out.println(moveCount.movingCount(2, 3, 1));
        System.out.println(moveCount.movingCount(3, 1, 0));
    }

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        return movingCount(0, 0, m, n, k, visited);
    }

    // 从（i，j）出发能到达的格子数
    private int movingCount(int i, int j, int m, int n, int k, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || invalidRange(i, j, k) || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;
        return 1 + movingCount(i - 1, j, m, n, k, visited)
                + movingCount(i, j - 1, m, n, k, visited)
                + movingCount(i + 1, j, m, n, k, visited)
                + movingCount(i, j + 1, m, n, k, visited);
    }

    private static boolean invalidRange(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum > k;
    }
}
