package backtrack;

class SearchWorld {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visit = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean result = exist(board, i, j, word, 0, visit);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int rowStartIndex, int colStartIndex, String word, int currentCharIndex, boolean[][] visit) {
        if (board[rowStartIndex][colStartIndex] != word.charAt(currentCharIndex)) {
            return false;
        }

        if (!visit[rowStartIndex][colStartIndex]) {

            visit[rowStartIndex][colStartIndex] = true;

            if (currentCharIndex == word.length() - 1) {
                return true;
            }

            boolean result =
                    (rowStartIndex + 1 < board.length && exist(board, rowStartIndex + 1, colStartIndex, word, currentCharIndex + 1, visit))
                            || (rowStartIndex - 1 >= 0 && exist(board, rowStartIndex - 1, colStartIndex, word, currentCharIndex + 1, visit))
                            || (colStartIndex - 1 >= 0 && exist(board, rowStartIndex, colStartIndex - 1, word, currentCharIndex + 1, visit))
                            || (colStartIndex + 1 < board[0].length && exist(board, rowStartIndex, colStartIndex + 1, word, currentCharIndex + 1, visit));

            visit[rowStartIndex][colStartIndex] = false;

            return result;
        }

        return false;
    }
}