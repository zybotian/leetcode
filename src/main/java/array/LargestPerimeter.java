package array;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2, 1, 2};
        int[] arr2 = {1, 2, 1};
        int[] arr3 = {3, 2, 3, 4};
        int[] arr4 = {3, 6, 2, 3};

        System.out.println(solution.largestPerimeter(arr1));
        System.out.println(solution.largestPerimeter(arr2));
        System.out.println(solution.largestPerimeter(arr3));
        System.out.println(solution.largestPerimeter(arr4));

    }

    static class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 1; i >= 2; i--) {
                if (A[i] < A[i - 1] + A[i - 2]) {
                    return A[i] + A[i - 1] + A[i - 2];
                }
            }
            return 0;
        }
    }
}
