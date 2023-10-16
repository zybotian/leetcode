package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(1));
        System.out.println(nQueens.solveNQueens(2));
        System.out.println(nQueens.solveNQueens(3));
        System.out.println(nQueens.solveNQueens(4));
        System.out.println(nQueens.solveNQueens(5));
        System.out.println(nQueens.solveNQueens(6));
        System.out.println(nQueens.solveNQueens(7));
        System.out.println(nQueens.solveNQueens(8));
        System.out.println(nQueens.solveNQueens(9));
    }

    public List<List<String>> solveNQueens(int n) {
        // 初始化为空棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // 结果
        List<List<String>> result = new ArrayList<>();
        // 执行回溯算法
        backtrack(board, 0, result);
        // 返回结果
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        // 找到一种答案
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[i].length; j++) {
                    sb.append(board[i][j]);
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }

        int n = board[row].length;

        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1, result);
            board[row][col] = '.';
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[row].length;

        if (row < 0 || row >= rows) {
            return false;
        }
        if (col < 0 || col >= cols) {
            return false;
        }

        // 所在行的检查
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        // 所在列的检查
        for (int j = 0; j < row; j++) {
            if (board[j][col] == 'Q') {
                return false;
            }
        }

        // 左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < cols; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
