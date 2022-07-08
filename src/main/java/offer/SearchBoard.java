package offer;

public class SearchBoard {

    public static void main(String[] args) {
        SearchBoard searchBoard = new SearchBoard();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(searchBoard.exist(board, "A"));
        System.out.println(searchBoard.exist(board, "B"));
        System.out.println(searchBoard.exist(board, "C"));
        System.out.println(searchBoard.exist(board, "E"));
        System.out.println(searchBoard.exist(board, "S"));
        System.out.println(searchBoard.exist(board, "F"));
        System.out.println(searchBoard.exist(board, "C"));
        System.out.println(searchBoard.exist(board, "S"));

        System.out.println(searchBoard.exist(board, "A"));
        System.out.println(searchBoard.exist(board, "D"));
        System.out.println(searchBoard.exist(board, "E"));
        System.out.println(searchBoard.exist(board, "E"));

        System.out.println(searchBoard.exist(board, "ABCE"));

        System.out.println(searchBoard.exist(board, "SFCS"));
        System.out.println(searchBoard.exist(board, "ADEE"));
        System.out.println(searchBoard.exist(board, "ASA"));
        System.out.println(searchBoard.exist(board, "BFD"));
        System.out.println(searchBoard.exist(board, "CCE"));
        System.out.println(searchBoard.exist(board, "ESE"));
        System.out.println(searchBoard.exist(board, "ABFD"));
        System.out.println(searchBoard.exist(board, "ABCCED"));
        System.out.println(searchBoard.exist(board, "ABCCEE"));
        System.out.println(searchBoard.exist(board, "ABCCSE"));
        System.out.println(searchBoard.exist(board, "ABCD"));
        System.out.println(searchBoard.exist(board, "ABCEF"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchBoard(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchBoard(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || visited[i][j]
                || word.charAt(k) != board[i][j]) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = searchBoard(board, i, j + 1, word, k + 1, visited)
                || searchBoard(board, i + 1, j, word, k + 1, visited)
                || searchBoard(board, i - 1, j, word, k + 1, visited)
                || searchBoard(board, i, j - 1, word, k + 1, visited);
        visited[i][j] = false;
        return result;
    }
}
