package offer;

/**
 * @author tianbo
 * @date 2019-06-13
 */
public class MatrixSearchWord {

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'd'},
                {'e', 'g', 'h', 'k'},
                {'m', 'n', 'p', 'q'},
                {'q', 'w', 'x', 'y'}};
        System.out.println(findTarget(board, "abcd"));
        System.out.println(findTarget(board, "aemq"));
        System.out.println(findTarget(board, "dkqy"));
        System.out.println(findTarget(board, "yxwq"));
        System.out.println(findTarget(board, "dkqy"));
        System.out.println(findTarget(board, "abcdkqyxwqmeghpn"));
        System.out.println(findTarget(board, "ghkdcba"));
        System.out.println(findTarget(board, "bghpnmqw"));
        System.out.println(findTarget(board, "aemqwnm"));
        System.out.println(findTarget(board, "aemw"));
        System.out.println(findTarget(board, "aemnpqo"));
    }

    public static boolean findTarget(char[][] board, String target) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasPath(board, visited, i, j, target, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(char[][] board, boolean[][] visited, int row, int col, String target, int current) {
        if (current < 0 || current > target.length() || row < 0 || row >= board.length || col < 0 || col >= board[0]
                .length) {
            return false;
        }
        // 每找到一个符合的字母,current自增1
        if (current == target.length()) {
            return true;
        }
        boolean hasPath = false;
        if (board[row][col] == target.charAt(current) && !visited[row][col]) {
            visited[row][col] = true;
            current++;
            hasPath = hasPath(board, visited, row + 1, col, target, current)
                    || hasPath(board, visited, row, col + 1, target, current)
                    || hasPath(board, visited, row - 1, col, target, current)
                    || hasPath(board, visited, row, col - 1, target, current);
        }

        // 回溯
        if (!hasPath) {
            visited[row][col] = false;
            current--;
        }
        return hasPath;
    }
}
