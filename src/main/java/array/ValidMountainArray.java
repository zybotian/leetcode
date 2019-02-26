package array;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data1 = {0, 3, 2, 1};
        System.out.println(solution.validMountainArray(data1));

        int[] data2 = {2, 1};
        System.out.println(solution.validMountainArray(data2));

        int[] data3 = {3, 5, 5};
        System.out.println(solution.validMountainArray(data3));

        int[] data4 = {0, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(solution.validMountainArray(data4));
    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) {
                return false;
            }

            int i = 0, j = A.length - 1;
            while (i < A.length - 1 && A[i] < A[i + 1]) {
                i++;
            }

            if (i == A.length - 1) {
                return false;
            }

            while (j > 0 && A[j] < A[j - 1]) {
                j--;
            }
            if (j == 0) {
                return false;
            }
            return i == j;
        }
    }
}
