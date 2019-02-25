package array;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class NumRookCaptures {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] arr1 = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(solution.numRookCaptures(arr1));

        char[][] arr2 = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(solution.numRookCaptures(arr2));

    }

    static class Solution {
        public int numRookCaptures(char[][] board) {
            int ri = 0, rj = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 'R') {
                        ri = i;
                        rj = j;
                        break;
                    }
                }
            }

            int result = 0;

            // up
            for (int i = ri - 1; i >= 0; i--) {
                if (board[i][rj] == 'p') {
                    result++;
                    break;
                }
                if (board[i][rj] == 'B') {
                    break;
                }
            }
            // down
            for (int i = ri + 1; i < 8; i++) {
                if (board[i][rj] == 'p') {
                    result++;
                    break;
                }
                if (board[i][rj] == 'B') {
                    break;
                }
            }

            // left
            for (int j = rj - 1; j >= 0; j--) {
                if (board[ri][j] == 'p') {
                    result++;
                    break;
                }
                if (board[ri][j] == 'B') {
                    break;
                }
            }
            // right
            for (int j = rj + 1; j < 8; j++) {
                if (board[ri][j] == 'p') {
                    result++;
                    break;
                }
                if (board[ri][j] == 'B') {
                    break;
                }
            }

            return result;
        }
    }
}
