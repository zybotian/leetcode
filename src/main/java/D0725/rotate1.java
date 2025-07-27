package D0725;

import java.util.Arrays;

class rotate1 {
    public static void main(String[] args) {
        rotate1 rotate = new rotate1();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate.rotate(matrix);
        display(matrix);
    }

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // {5,  1,  9,  11}
        // {2,  4,  8,  10}
        // {13, 3,  6,  7}
        // {15, 14, 12, 16}
        // 先按对角线旋转
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 旋转后的结果
        // {5,  2,  13, 15}
        // {1,  4,  3,  14}
        // {9,  8,  6,  12}
        // {11, 10, 7,  16}

        // 再按列交换，第1列和第4列换，第2列和第3列换
        // {5,  2,  13, 15}
        // {1,  4,  3,  14}
        // {9,  8,  6,  12}
        // {11, 10, 7,  16}
        for (int i = 0; i < cols / 2; i++) {
            swapCol(matrix, i, cols - 1 - i);
        }
    }

    private void swapCol(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = tmp;
        }
    }

    private static void display(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }
}