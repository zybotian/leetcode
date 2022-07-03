package offer;

import util.PrintUtils;

public class SpiralOrder {

    // 1 2 3 4 5
    // 6 7 8 9 10
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int index = 0;

        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }

            for (int i = top + 1; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }

            // 兼容只有一行的特殊情况
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
            }

            // 兼容只有一列的特殊情况
            if (left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    result[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {
                {11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22},
                {23, 24, 25, 26}
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix));

        int[][] matrix2 = {
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35}
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix2));

        int[][] matrix3 = {
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30},
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix3));

        int[][] matrix4 = {
                {11, 12, 13, 14},
                {16, 17, 18, 19},
                {21, 22, 23, 24},
                {26, 27, 28, 29},
                {31, 32, 33, 34}
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix4));

        int[][] matrix5 = {
                {11, 12, 13, 14}
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix5));

        int[][] matrix6 = {
                {11},
                {12},
                {13},
                {14}
        };
        PrintUtils.printBeauty(spiralOrder.spiralOrder(matrix6));
    }
}
