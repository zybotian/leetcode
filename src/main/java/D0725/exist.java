package D0725;

class exist {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        exist exist = new exist();
        System.out.println(exist.exist(board, "ABCCED"));
        System.out.println(exist.exist(board, "SEE"));
        System.out.println(exist.exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, i, j, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int k, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (k < 0 || k >= word.length() || word.charAt(k) != board[i][j]) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visit[i][j] = true;
        boolean found = find(board, i + 1, j, word, k + 1, visit)
                || find(board, i - 1, j, word, k + 1, visit)
                || find(board, i, j + 1, word, k + 1, visit)
                || find(board, i, j - 1, word, k + 1, visit);
        visit[i][j] = false;
        return found;
    }
}