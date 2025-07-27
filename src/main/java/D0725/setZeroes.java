package D0725;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class setZeroes {
    public static void main(String[] args) {
        setZeroes setZeroes = new setZeroes();
        int[][] arr1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes.setZeroes(arr1);
        display(arr1);

        int[][] arr2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes.setZeroes(arr2);
        display(arr2);
    }

    private static void display(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row : rows) {
            resetRow(matrix, row);
        }

        for (Integer col : cols) {
            resetCol(matrix, col);
        }
    }

    private void resetCol(int[][] matrix, Integer col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    private void resetRow(int[][] matrix, Integer row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
}