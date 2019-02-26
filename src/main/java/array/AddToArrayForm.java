package array;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 6};
        int k = 12398;
        System.out.println(solution.addToArrayForm(arr, k));

        int[] arr2 = {0};
        int k2 = 23;
        System.out.println(solution.addToArrayForm(arr2, k2));

        int[] arr3 = {23};
        int k3 = 0;
        System.out.println(solution.addToArrayForm(arr3, k3));
    }

    static class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            int[] B = convertToInts(K);
            return addArray(A, B);
        }

        private List<Integer> addArray(int[] a, int[] b) {
            int aLength = a.length, bLength = b.length;

            int i = aLength - 1, j = bLength - 1;
            int carry = 0;
            Stack<Integer> stack = new Stack<>();
            while (i >= 0 || j >= 0) {
                if (i >= 0 && j >= 0) {
                    int tmp = carry + a[i] + b[j];
                    stack.push(tmp % 10);
                    carry = tmp / 10;
                    i--;
                    j--;
                } else if (i >= 0 && j < 0) {
                    int tmp = carry + a[i];
                    stack.push(tmp % 10);
                    carry = tmp / 10;
                    i--;
                } else {
                    int tmp = carry + b[j];
                    stack.push(tmp % 10);
                    carry = tmp / 10;
                    j--;
                }
            }
            if (carry > 0) {
                stack.push(carry);
            }

            List<Integer> result = new LinkedList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            return result;
        }

        private int[] convertToInts(int k) {
            int[] result = new int[String.valueOf(k).length()];
            int i = result.length - 1;
            while (k != 0) {
                result[i--] = k % 10;
                k /= 10;
            }
            return result;
        }
    }

}

