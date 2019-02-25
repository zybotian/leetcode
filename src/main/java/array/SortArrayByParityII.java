package array;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 2, 5, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {2, 1, 4, 3, 6, 5};
        int[] arr4 = {1, 1, 4, 3, 6, 8};
        int[] arr5 = {2, 3, 1, 1, 4, 0, 0, 4, 3, 3};


        System.out.println(Arrays.toString(solution.sortArrayByParityII(arr1)));
        System.out.println(Arrays.toString(solution.sortArrayByParityII(arr2)));
        System.out.println(Arrays.toString(solution.sortArrayByParityII(arr3)));
        System.out.println(Arrays.toString(solution.sortArrayByParityII(arr4)));
        System.out.println(Arrays.toString(solution.sortArrayByParityII(arr5)));

    }

    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int[] result = new int[A.length];
            int k0 = 0, k1 = 1;
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & 1) == 0) {
                    result[k0] = A[i];
                    k0 += 2;
                } else {
                    result[k1] = A[i];
                    k1 += 2;
                }
            }

            return result;
        }
    }
}
