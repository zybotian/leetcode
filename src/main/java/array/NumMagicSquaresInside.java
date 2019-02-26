package array;

import java.util.TreeSet;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class NumMagicSquaresInside {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}};
        System.out.println(solution.numMagicSquaresInside(arr));

        int[][] arr2 = {{5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}};
        System.out.println(solution.numMagicSquaresInside(arr2));

        int[][] arr3 = {
                {3, 2, 9, 2, 7},
                {6, 1, 8, 4, 2},
                {7, 5, 3, 2, 7},
                {2, 9, 4, 9, 6},
                {4, 3, 8, 2, 5}};
        System.out.println(solution.numMagicSquaresInside(arr3));

        int[][] arr4 = {
                {6, 1, 8},
                {7, 5, 3},
                {2, 9, 4},
        };
        System.out.println(solution.numMagicSquaresInside(arr4));
    }

    static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int count = 0;
            for (int i = 0; i < rows - 2; i++) {
                for (int j = 0; j < cols - 2; j++) {
                    if (isMagicSquare(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isMagicSquare(int[][] grid, int startRow, int startCol) {
            int endRow = startRow + 2;
            int endCol = startCol + 2;

            int[] sumRow = new int[3];
            int[] sumCol = new int[3];
            int sumLeftDiagonal = 0, sumRightDiagonal = 0;
            TreeSet<Integer> elementSet = new TreeSet<>();
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    // 数字范围必须是1-9
                    if (grid[i][j] < 1 || grid[i][j] > 9) {
                        return false;
                    }

                    sumRow[i - startRow] += grid[i][j];
                    sumCol[j - startCol] += grid[i][j];
                    // 左上到右下的对角线
                    if ((i == startRow && j == startCol) || (i == startRow + 1 && j == startCol + 1) || (i == endRow
                            && j == endCol)) {
                        sumLeftDiagonal += grid[i][j];
                    }
                    // 右上到左下的对角线
                    if ((i == startRow && j == endCol) || (i == startRow + 1 && j == endCol - 1) || (i == startRow +
                            2 && j == endCol - 2)) {
                        sumRightDiagonal += grid[i][j];
                    }
                    elementSet.add(grid[i][j]);
                }
            }

            // 两个对角线的和必须是15
            if (sumRightDiagonal != 15 || sumLeftDiagonal != 15) {
                return false;
            }

            // 元素必须是1-9且各个数字都只出现一次
            if (elementSet.size() != 9 || elementSet.first() != 1 || elementSet.last() != 9) {
                return false;
            }

            for (int i = 0; i < 3; i++) {
                // 每一行的和必须是15
                if (sumRow[i] != 15) {
                    return false;
                }
                // 每一列的和必须是15
                if (sumCol[i] != 15) {
                    return false;
                }
            }

            return true;
        }
    }
}
