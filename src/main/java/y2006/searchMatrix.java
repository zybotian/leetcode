package y2006;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        searchMatrix searchMatrix = new searchMatrix();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean res = searchMatrix.searchMatrix(matrix, 5);
        System.out.println(res);
    }
}
