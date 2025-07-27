package D0725;

class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix2 = new SearchMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix2.searchMatrix(matrix, 3));
        System.out.println(searchMatrix2.searchMatrix(matrix, 30));
        System.out.println(searchMatrix2.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }

        return false;
    }
}