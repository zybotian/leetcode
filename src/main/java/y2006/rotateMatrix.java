package y2006;

import java.util.Arrays;

public class rotateMatrix {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 先上下翻转，即第一行和最后一行交换，第二行和倒数第二行交换
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols; j++) {
                swap(matrix, i, j, rows - 1 - i, j);
            }
        }
        // 再按斜对角线转置
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int s, int t) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[s][t];
        matrix[s][t] = tmp;
    }

    public static void main(String[] args) {
        rotateMatrix rotateMatrix = new rotateMatrix();
        int[][] ints1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix.rotate(ints1);
        displayMatrix(ints1);

        int[][] ints2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrix.rotate(ints2);
        displayMatrix(ints2);
    }

    private static void displayMatrix(int[][] ints1) {
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(Arrays.toString(ints1[i]));
        }
    }
}
